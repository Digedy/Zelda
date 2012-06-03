import org.newdawn.slick.*;

/**
 * Created by IntelliJ IDEA.
 * PACKAGE_NAME
 * Author: Timothy "Awesome" Vens
 * Date: 28/03/12
 * Time: 14:14
 */
public class Test extends BasicGame {
    private Player player;
    private Enemy enemy;
    private Image bg;

    public Test(String title) {
        super(title);
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Test("Zelda"));
        app.setTargetFrameRate(60);
        app.setDisplayMode(800, 600, false);
        app.start();
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        player = new Player(0, 0, new Image("./img/spritesheet.png").getSubImage(20,0,15,20).getScaledCopy(2f));
        enemy = new Enemy(100, 100, new Image("./img/enemy.png").getScaledCopy(1.5f));
        bg = new Image("./img/background.png");
        bg = bg.getScaledCopy(gameContainer.getWidth(), gameContainer.getHeight());
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {

        if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT) == true) {
            if (player.collision(enemy, 5f, 0) == false) {
                player.move("right");
            }

        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT) == true) {
            if (player.collision(enemy, -5f, 0) == false) {
                player.move("left");
            }
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_DOWN) == true) {
            if (player.collision(enemy, 0, 5f) == false) {
                player.move("down");
            }
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_UP) == true) {
            if (player.collision(enemy, 0, -5f) == false) {
                player.move("up");
            }
        }

    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        bg.draw();
        player.draw();
    }


}
