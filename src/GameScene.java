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
    private ArrayList<Foe> foes=new ArrayList<Foe>();
    private Foe foe;
    private double var1=0;
    private double v_0=200;
    int i=0;

    public Camera GetCam(){
        return this.camera;
    }
    public GameScene(Pane pane, double v, double v1,boolean b) {
        super(pane, v, v1, b);
        this.background();
        this.foe();
        this.hero();
        this.health();
        //timer.start();
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
                hero.index=0;
                hero.yperso = 260;
            }
        });
        this.setOnKeyReleased((event) -> {
            if (event.getCode().equals(KeyCode.D)) {
                hero.setAccelerate(false);
                System.out.println("non ");
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
                    update(time, pane);
                    //for (Foe foe : foes){ //boucle for améliorée pour parcourir le tab de foes
                        foe.update(time,camera.getV(),now);
                    //}
                    heart.update(time);
                    lastUpdate=now;
                }
            }
        };
        timer.start();
    }

    private staticThing left;
    private staticThing right;

    private Health heart;


    /*AnimationTimer timer = new AnimationTimer() {
        private long lastUpdate=0;
        @Override
        public void handle(long now) {
            double time=(now-lastUpdate)*Math.pow(10,-9);
            if(time > 0.11){
                hero.update(time,v_0,camera);
                GetCam().update(time, hero.xperso);
                update(time, pane);
                for (Foe foe : foes){ //boucle for améliorée pour parcourir le tab de foes
                    foe.update(time,camera.getV());
                }
                heart.update(time);
                lastUpdate=now;
            }
        }
    };*/

    public void background() {
        left = new staticThing(0, 0, 500+var1, 0, 300-var1, 400, "forest.jpg");
        right = new staticThing(300-var1, 0, 0, 0, 300+var1, 400, "forest.jpg");
        // augmenter w de right et x de left ET diminuer posx de right
        // augmenter x de right (avec var2) ET mettre posx de left à 600 et x de left à [ ] (avec var)
    }

    public void hero(){
        hero = new Hero(200, 260, 0, 0,48,48,"little_hero.png","running");
    }
    public void health(){
        heart = new Health(2, 5,0,0,87,27,"heart.png","3vies");
    //écart de 29 pixels pour passer au coeur suivant
    }
    public void foe(){
        foe= new Foe(700,230,0,0,80,102,"ghost.png","alive");
    }

    public void display(Pane pane){
        pane.getChildren().add(left.getSprite());
        pane.getChildren().add(right.getSprite());
        pane.getChildren().add(heart.getSprite());
        pane.getChildren().add(foe.getSprite());
        pane.getChildren().add(hero.getSprite());
    }

    public void update(double time, Pane pane) {
        var1=(var1 + camera.getV()*time)%564;
        left.getSprite().setViewport(new Rectangle2D(var1, 0, 564-var1, 400));
        right.getSprite().setViewport(new Rectangle2D(0, 0, var1, 400));
        right.getSprite().setX(564 - var1);
        //for (Foe foe : foes){
            if(!hero.IsInvisible()&&hero.getHitbox().intersects(foe.getHitbox())){
                System.out.println("tape !");
                heart.nboflife-=1;
                hero.attitude="hurt";
                hero.setInvisibility(1.5);
                if(heart.nboflife==0) hero.attitude="death";
            }
        //}
        /*System.out.println(Math.random()*10);
        System.out.println(i);
        if (i> Math.random()*10){
            System.out.println("if");
            Foe foe=new Foe(hero.xperso+1000+Math.random()*10,230,0,0,80,102,"ghost.png","alive");
            foes.add(foe);
            pane.getChildren().add(foe.getSprite());
            System.out.println(foe.xperso + "où est le méchant ?");
            i=0;
        }else{
            i++;
        }*/

    }
}
