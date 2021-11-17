import com.sun.javafx.collections.SetAdapterChange;
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class GameScene extends Scene {
    private Hero hero;
    private Camera camera;
    private ArrayList<Foe> foes=new ArrayList<Foe>();
    private Foe foe;
    private double index;
    private double var=0;
    private double var1=0;
    private double var2=0;
    private double v_0=200;

    public Camera GetCam(){
        return this.camera;
    }
    public GameScene(Pane pane, double v, double v1,boolean b) {
        super(pane, v, v1, b);
        this.background();
        this.hero();
        this.health();
        this.foe();
        timer.start();
        this.display(pane);
        camera = new Camera(0, 0);
        this.setOnKeyPressed((event) -> {
            if (event.getCode().equals(KeyCode.D)) {
                hero.xperso+=5;
                hero.setAccelerate(true);
                // utiliser Accelerate(True) qd pressed et (False) qd released
                // idée : faire accelerate =true / false pour mettre une condition if avec jumping & D.
            }
            if (event.getCode().equals(KeyCode.SPACE)) {
                System.out.println("yes");
                hero.attitude = "jumping up";
                System.out.println(hero.xperso);
                hero.yperso = 210;
            }
        });
        this.setOnKeyReleased((event) -> {
            if (event.getCode().equals(KeyCode.D)) {
                hero.setAccelerate(false);
                System.out.println("non ");
            }
        });
    }

    private staticThing left;
    private staticThing right;

    private Health heart;


    AnimationTimer timer = new AnimationTimer() {
        private long lastUpdate=0;
        @Override
        public void handle(long now) {
            double time=(now-lastUpdate)*Math.pow(10,-9);
            if(time > 0.11){
                //System.out.println("time avant "+time);
                hero.update(time,v_0,camera);
                GetCam().update(time, hero.xperso);
                update(time);
                foe.update(time,camera.getV());
                lastUpdate=now;
            }
        }
    };

    public void background() {
        left = new staticThing(0, 0, 500+var1, 0, 300-var1, 400, "forest.jpg");
        right = new staticThing(300-var1, 0, 0, 0, 300+var1, 400, "forest.jpg");
        // augmenter w de right et x de left ET diminuer posx de right
        // augmenter x de right (avec var2) ET mettre posx de left à 600 et x de left à [ ] (avec var)
    }

    public void hero(){
        hero = new Hero(200, 210, 0, 0,85,100,"heros.png","running");
    }
    public void health(){
        heart = new Health(2, 5,0,0,87,27,"heart.png","3vies");
    //écart de 29 pixels pour passer au coeur suivant
    }
    public void foe(){
        foe= new Foe(600,240,8,0,45,70,"foe.png","alive");
    }

    public void display(Pane pane){
        pane.getChildren().add(left.getSprite());
        pane.getChildren().add(right.getSprite());
        pane.getChildren().add(hero.getSprite());
        pane.getChildren().add(heart.getSprite());
        pane.getChildren().add(foe.getSprite());
    }

    public void update(double time) {
        var1=(var1 + camera.getV()*time)%564;
        left.getSprite().setViewport(new Rectangle2D(var1, 0, 564-var1, 400));
        right.getSprite().setViewport(new Rectangle2D(0, 0, var1, 400));
        right.getSprite().setX(564 - var1);
        //System.out.println("hero " +hero.getHitbox());
        //System.out.println("foe "+foe.getHitbox());
        if(hero.getHitbox().intersects(new Rectangle2D(600,290,45,70))){ //foe.getHitbox()
            heart.nboflife-=1;
            System.out.println("tape !");
        }
    }
}
