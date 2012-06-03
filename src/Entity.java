import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;

/**
 * Created by IntelliJ IDEA.
 * User: Digedy
 * Date: 2/04/12
 * Time: 18:50
 * To change this template use File | Settings | File Templates.
 */
public class Entity {
    private float x;
    private float y;
    private float MOV_SPEED = 3f;
    private Image sprite;
    private Image sheet;
    private Image[] neutral = new Image[4];
    private Image[] walk = new Image[16];
    private Animation down;
    private Animation left;
    private Animation right;
    private Animation up;
    private Animation neutralAnim;
    private boolean moving = false;
    private String direction;

    public Entity(float x, float y, Image sprite) throws SlickException {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.sheet = new Image("./img/spritesheet.png");
        fill();
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void move(String direction) {
        if (direction.equalsIgnoreCase("right")) {
            this.x += MOV_SPEED;
            moving = true;
            this.direction = direction;
        }
        if (direction.equalsIgnoreCase("left")) {
            this.x -= MOV_SPEED;
            moving = true;
            this.direction = direction;
        }
        if (direction.equalsIgnoreCase("down")) {
            this.y += MOV_SPEED;
            moving = true;
            this.direction = direction;
        }
        if (direction.equalsIgnoreCase("up")) {
            this.y -= MOV_SPEED;
            moving = true;
            this.direction = direction;
        }
    }

    public void draw() {
        if (moving == true && direction == "down") {
            down.draw(x, y);
        }
        if (moving == true && direction == "up") {
            up.draw(x, y);
        }
        if (moving == true && direction == "right") {
            right.draw(x, y);
        }
        if (moving == true && direction == "left") {
            left.draw(x, y);
        }
        if (moving == false) {
            neutralAnim.draw(x, y);
        }
        moving = false;
    }

    public boolean collision(Entity e, float movx, float movy) {
        Rectangle r1 = new Rectangle((int) (x + movx), (int) (y + movy), sprite.getWidth() - 10, sprite.getHeight() - 5);
        Rectangle r2 = new Rectangle((int) e.x, (int) e.y, e.sprite.getWidth() - 10, e.sprite.getHeight() - 5);
        if (r1.intersects(r2) == true) {
            return true;
        } else {
            return false;
        }
    }

    public void fill() {
        int x = 0;
        int y = 0;
        for (int i = 0; i < 16; i++) {
            walk[i] = sheet.getSubImage(x, 0, 15, 19).getScaledCopy(2f);
            x += 20;
        }
        x = 0;
        for (int i = 0; i < 2; i++) {
            neutral[i] = sheet.getSubImage(x, 20, 15, 19).getScaledCopy(2f);
            x += 20;
        }
        down = new Animation();
        left = new Animation();
        right = new Animation();
        up = new Animation();
        neutralAnim = new Animation();
        for (int j = 0; j < 16; j++) {
            if (j < 4) {
                down.addFrame(walk[j], 150);
            }
            if (j > 3 && j < 8) {
                left.addFrame(walk[j], 150);
            }
            if (j > 7 && j < 12) {
                right.addFrame(walk[j], 150);
            }
            if (j > 11) {
                up.addFrame(walk[j], 150);
            }
        }
        for(int k = 0; k <2;k++){
            neutralAnim.addFrame(neutral[k],2000);
        }
         neutralAnim.setDuration(1,300);

    }

}
