
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
      //       AnimationTimer timer = new AnimationTimer() {
      //           @Override
      //           public void handle(long time) {
      //               theScene.hero().update(time);
      //               //theScene.GetCam().update(time);
      //               theScene.update(time,pane);
      //           }
      //       };
      //       timer.start();

         }
         public static void main(String[] args) {
         launch(args);
         }
    }

