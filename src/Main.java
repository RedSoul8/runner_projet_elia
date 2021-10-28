
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {

         @Override
         public void start(Stage primaryStage) throws Exception {

             primaryStage.setTitle("Runner");
             Group root = new Group();
             Pane pane = new Pane(root);
             GameScene theScene = new GameScene(pane, 600, 400,true);
             primaryStage.setScene(theScene);
             primaryStage.show();
//             AnimationTimer timer = new AnimationTimer() {
//                 private long lastUpdate=0;
//                 @Override
//                 public void handle(long now) {
//                     if(now - lastUpdate >= 90000000){
//                         theScene.hero.update(now);
//                         theScene.GetCam().update(now);
//                         theScene.update(now);
//                         lastUpdate=now;
//                     }
//                 }
//             };

         }
         public static void main(String[] args) {
         launch(args);
         }
    }

