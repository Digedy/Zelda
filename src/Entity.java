import org.newdawn.slick.Image;

import java.awt.*;

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
    private Image sprite;

    public Entity(float x, float y, Image sprite) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
    }

    public Entity() {
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void move(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public void draw() {
        sprite.draw(x, y);
    }

    public boolean collision(Entity e, float movx, float movy) {
        Rectangle r1 = new Rectangle((int) (x + movx), (int) (y + movy), sprite.getWidth(), sprite.getHeight());
        Rectangle r2 = new Rectangle((int) e.x, (int) e.y, e.sprite.getWidth(), e.sprite.getHeight());
        if (r2.intersects(r1) == true) {
            return true;
        } else {
            return false;
        }
    }
}
