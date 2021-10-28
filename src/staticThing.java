import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class staticThing {
    private double x;
    private double y;
    protected ImageView sprite;

    public staticThing (double posx, double posy, double x, double y, double w, double h, String filename) {
        Image spriteSheet = new Image(filename);
        sprite = new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(x,y,w,h));
        sprite.setX(posx);
        sprite.setY(posy);
    }

    public ImageView getSprite() {
        return sprite;
    }
}
