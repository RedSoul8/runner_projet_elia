import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AnimatedThing {
    protected double x;
    protected double y;
    protected double w;
    protected double h;
    protected ImageView sprite;
    protected String attitude="running";

    public double getIndex() {
        return index;
    }

    public void setIndex(double index) {
        this.index = index;
    }

    protected double index=0; // correspond à la position x (prise de l'image)
    protected double max_index=425;

    public double getXhero() {
        return xhero;
    }

    public void setXhero(double xhero) {
        this.xhero = xhero;
    }

    public double getYhero() {
        return yhero;
    }

    public void setYhero(double yhero) {
        this.yhero = yhero;
    }

    protected double xhero=200;
    protected double yhero=270;
    private long time; // between 2 frames
    private double size;
    private double offset; // between 2 frames

    public AnimatedThing(double xhero, double yhero, double index,double y, double w, double h, String filename, String attitude){
        Image spriteSheet = new Image(filename);
        sprite = new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(index, y, w, h));
        sprite.setX(xhero);
        sprite.setY(yhero);
    }

    public ImageView getSprite() {
        return sprite;
    }
}
