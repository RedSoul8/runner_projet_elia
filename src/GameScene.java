import com.sun.javafx.collections.SetAdapterChange;
import com.sun.prism.MaskTextureGraphics;
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
    private Ghost ghost;
    private Bat bat;
    protected double var1=0;
    private double v_0=200;

    public Camera GetCam(){
        return this.camera;
    }
    public GameScene(Pane pane, double v, double v1,boolean b) {
        super(pane, v, v1, b);
        this.background();
        this.foe();
        this.hero();
        this.health();
        this.display(pane);
        camera = new Camera(0, 0);
        this.setOnKeyPressed((event) -> {
            if (event.getCode().equals(KeyCode.D)) {
                hero.xperso+=5;
                hero.setAccelerate(true);
            }
            if (event.getCode().equals(KeyCode.SPACE)) {
                System.out.println("yes");
                hero.attitude = "jumping up";
                hero.index=0;
                hero.yperso = 260;
            }
        });
        this.setOnKeyReleased((event) -> {
            if (event.getCode().equals(KeyCode.D)) {
                hero.setAccelerate(false);
                System.out.println("non");
            }
        });
        AnimationTimer timer = new AnimationTimer() {
            private long lastUpdate=0;
            @Override
            public void handle(long now) {
                double time=(now-lastUpdate)*Math.pow(10,-9);
                if(time > 0.11){
                    hero.update(time,v_0,camera);
                    GetCam().update(time, hero.xperso);
                    update(time);
                    ghost.update(time,camera.getV());
                    bat.update(time,camera.getV());
                    heart.update(time);
                    lastUpdate=now;
                    System.out.println(hero.attitude);
                    if(hero.attitude=="end"){
                        stop();
                        gameover(pane);
                    }
                }
            }
        };
        timer.start();
    }

    private staticThing left;
    private staticThing right;
    private staticThing gameover;
    private Health heart;

    public void background() {
        left = new staticThing(0, 0, 500, 0, 300, 400, "forest.jpg");
        right = new staticThing(300, 0, 0, 0, 300, 400, "forest.jpg");
    }
    public void hero(){
        hero = new Hero(200, 260, 0, 0,48,48,"little_heros.png","running");
    }
    public void health(){
        heart = new Health(2, 5,0,0,87,27,"heart.png","3vies");
    }
    public void foe(){
        ghost = new Ghost(1000,230,0,0,80,102,"ghost.png","alive");
        bat = new Bat(800, 150,0,6,130,62,"flying_bat.png","alive");
    }
    public void gameover(Pane pane){
        gameover = new staticThing(0, 0, 0, 0, 564,400, "gameover.png");
        pane.getChildren().add(gameover.getSprite());
    }
    public void display(Pane pane){
        pane.getChildren().add(left.getSprite());
        pane.getChildren().add(right.getSprite());
        pane.getChildren().add(heart.getSprite());
        pane.getChildren().add(ghost.getSprite());
        pane.getChildren().add(bat.getSprite());
        pane.getChildren().add(hero.getSprite());
    }
    public void update(double time) {
        var1=(var1 + camera.getV()*time)%564;
        left.getSprite().setViewport(new Rectangle2D(var1, 0, 564-var1, 400));
        right.getSprite().setViewport(new Rectangle2D(0, 0, var1, 400));
        right.getSprite().setX(564 - var1);
        if(!hero.IsInvisible()&&hero.getHitbox().intersects(ghost.getHitbox())||!hero.IsInvisible()&&hero.getHitbox().intersects(bat.getHitbox())){
            System.out.println("tape !");
            heart.nboflife-=1;
            hero.attitude="hurt";
            hero.setInvisibility(1);
            if(heart.nboflife==0) hero.attitude="death";
        }
    }
}
