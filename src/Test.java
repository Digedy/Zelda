import org.newdawn.slick.*;

import java.util.ArrayList;

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
    private ArrayList<Image> walk = new ArrayList<Image>();
    private Image sheet;
    private float tempx;
    private float tempy;

    public Test(String title) {
        super(title);
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Test("Zelda"));
        app.setDisplayMode(800, 600, false);
        app.start();
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        player = new Player(0, 0, new Image("./img/Minish.png").getScaledCopy(1.5f));
        enemy = new Enemy(100, 100, new Image("./img/enemy.png").getScaledCopy(1.5f));
        bg = new Image("./img/background.png");
        sheet = new Image("./img/walkcycle.png");
        int x = 0;
        for (int i = 0; i < 10; i++) {
            walk.add(i, sheet.getSubImage(x, 0, 18, 24));
            x += 32;
        }
        bg = bg.getScaledCopy(gameContainer.getWidth(), gameContainer.getHeight());
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        if (gameContainer.getInput().isKeyDown(Input.KEY_RIGHT) == true) {
            if (player.collision(enemy, 0.5f, 0) == false) {
                player.move(0.5f, 0);
            }

        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_LEFT) == true) {
            if (player.collision(enemy, -0.5f, 0) == false) {
                player.move(-0.5f, 0);
            }
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_DOWN) == true) {
            if (player.collision(enemy, 0, 0.5f) == false) {
                player.move(0, 0.5f);
            }
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_UP) == true) {
            if (player.collision(enemy, 0, -0.5f) == false) {
                player.move(0, -0.5f);
            }
        }
        if (player.getX() > gameContainer.getWidth()) {
            player.move(-player.getX(), 0);
        }
        if (player.getX() < 0) {
            player.move(gameContainer.getWidth(), 0);
        }
        if (player.getY() > gameContainer.getHeight()) {
            player.move(0, -player.getY());
        }
        if (player.getY() < 0) {
            player.move(0, gameContainer.getHeight());
        }

    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        bg.draw();
        player.draw();
        enemy.draw();
    }


}
