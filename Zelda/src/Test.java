import org.newdawn.slick.*;

/**
 * Created by IntelliJ IDEA.
 * PACKAGE_NAME
 * Author: Timothy "Awesome" Vens
 * Date: 28/03/12
 * Time: 14:14
 */
public class Test extends BasicGame {

    private Image player;
    private float x = 0;
    private float y = 0;
    private Image bg;
    private Image bal;
    private float balx = 100;
    private float baly = 100;

    public Test(String title) {
        super(title);
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Test("Zelda"));
        app.setDisplayMode(800,600,false);
        app.start();
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
                         player=new Image("./img/Minish.png");
        bg=new Image("./img/background.png");
        bg = bg.getScaledCopy(gameContainer.getWidth(),gameContainer.getHeight());
        bal = new Image("./img/bal.png");
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
       if(gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)==true){
           x+=0.5;
       }
        if(gameContainer.getInput().isKeyDown(Input.KEY_LEFT)==true){
           x-=0.5;
       }
        if(gameContainer.getInput().isKeyDown(Input.KEY_DOWN)==true){
           y+=0.5;
       }
        if(gameContainer.getInput().isKeyDown(Input.KEY_UP)==true){
           y-=0.5;
       }
        if(x>gameContainer.getWidth()){
            x=0;
        }
        if(x<0){
            x=gameContainer.getWidth();
        }
         if(y>gameContainer.getHeight()){
            y=0;
        }
        if(y<0){
            y=gameContainer.getHeight();
        }
        if(x==balx && y==baly){

        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        bg.draw();
        player.draw(x,y);
        bal.draw(balx,baly);
    }
}
