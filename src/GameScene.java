import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class GameScene extends Scene {
    private Hero hero;
    private Camera camera;
    private double index;
    private double var=0;
    private double var1=100;
    private double var2=0;

    public Camera GetCam(){
        return this.camera;
    }
    public GameScene(Pane pane, double v, double v1,boolean b) {
        super(pane, v, v1, b);
        this.background();
        this.hero();
        this.health();
        timer.start();
        this.display(pane);
    }

    private staticThing left;
    private staticThing right;

    private staticThing heart;

    AnimationTimer timer = new AnimationTimer() {
        private long lastUpdate=0;
        @Override
        public void handle(long now) {
            if(now - lastUpdate >= 90000000){
                hero.update(now);
               // GetCam().update(now, hero.xhero);
                update(now);
                lastUpdate=now;
            }
        }
    };

    public void background() {
       // left = new staticThing(0, 0, 500+var1, 0, 300-var1, 400, "C:\\Users\\Elia\\Documents\\ENSEA\\cours_ENSEA_2A\\INFORMATIQUE\\java\\runner\\desert.png");
       // right = new staticThing(300-var1, 0, 0, 0, 300+var1, 400, "C:\\Users\\Elia\\Documents\\ENSEA\\cours_ENSEA_2A\\INFORMATIQUE\\java\\runner\\desert.png");
        left = new staticThing(0, 0, 500+var1, 0, 300-var1, 400, "C:\\Users\\Elia\\Documents\\ENSEA\\cours_ENSEA_2A\\INFORMATIQUE\\java\\runner\\halloween_forest.PNG");
        right = new staticThing(300-var1, 0, 0, 0, 300+var1, 400, "C:\\Users\\Elia\\Documents\\ENSEA\\cours_ENSEA_2A\\INFORMATIQUE\\java\\runner\\halloween_forest.PNG");
        // augmenter w de right et x de left ET diminuer posx de right
        // augmenter x de right (avec var2) ET mettre posx de left à 600 et x de left à [ ] (avec var)
    }

    public void hero(){
        //hero = new Hero(200, 250, 0, 0,85,100,"C:\\Users\\Elia\\Documents\\ENSEA\\cours_ENSEA_2A\\INFORMATIQUE\\java\\runner\\heros.png","running");
        hero = new Hero(200, 250, 0, 0,85,100,"C:\\Users\\Elia\\Documents\\ENSEA\\cours_ENSEA_2A\\INFORMATIQUE\\java\\runner\\heros2.png","running");
    }
    public void health(){
        heart = new staticThing(2, 5,0,0,87,27,"C:\\Users\\Elia\\Documents\\ENSEA\\cours_ENSEA_2A\\INFORMATIQUE\\java\\runner\\heart.png");
    //écart de 29 pixels pour passer au coeur suivant
    }

    public void display(Pane pane){
        pane.getChildren().add(left.getSprite());
        pane.getChildren().add(right.getSprite());
        pane.getChildren().add(hero.getSprite());
        pane.getChildren().add(heart.getSprite());
    }

    public void update(long now) {
        var1+=25;
        //var1=var1%800;
        var1=var1%1429;
        //left.getSprite().setViewport(new Rectangle2D(var1, 0, 800-var1, 400));
        left.getSprite().setViewport(new Rectangle2D(var1, 0, 1429-var1, 400));
        right.getSprite().setViewport(new Rectangle2D(0, 0, var1, 400));
        //right.getSprite().setX(800 - var1);
        right.getSprite().setX(1429 - var1);
    }
}
