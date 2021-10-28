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

    public Camera GetCam(){
        return camera;
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
                GetCam().update(now);
                update(now);
                lastUpdate=now;
            }
        }
    };

    public void background() {
        left = new staticThing(0, 0, 500, 0, 300, 400, "C:\\Users\\Elia\\Documents\\ENSEA\\cours_ENSEA_2A\\INFORMATIQUE\\java\\runner\\desert.png");
        right = new staticThing(300, 0, 0, 0, 300, 400, "C:\\Users\\Elia\\Documents\\ENSEA\\cours_ENSEA_2A\\INFORMATIQUE\\java\\runner\\desert.png");
    }

    public void hero(){
        hero = new Hero(200,255, 0, 0,85,100,"C:\\Users\\Elia\\Documents\\ENSEA\\cours_ENSEA_2A\\INFORMATIQUE\\java\\runner\\heros.png","running");
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

    public void update(long time) {

    }
}
