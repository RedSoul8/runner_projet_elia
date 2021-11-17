import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AnimatedThing {
    protected double x;
    protected double y;
    protected double w;
    protected double h;
    protected Rectangle2D hitbox;

    public void setAccelerate(Boolean accelerate) {
        this.accelerate = accelerate;
    }

    protected Boolean accelerate=false;
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

    public double getXperso() {
        return xperso;
    }

    public void setXperso(double xperso) {
        this.xperso = xperso;
    }

    public double getYperso() {
        return yperso;
    }

    public void setYperso(double yperso) {
        this.yperso = yperso;
    }

    protected double xperso;
    protected double yperso;
    private long time; // between 2 frames
    private double size;
    private double offset; // between 2 frames

    public AnimatedThing(double xperso, double yperso, double index,double y, double w, double h, String filename, String attitude){
        this.index = index;
        this.xperso=xperso;
        this.yperso=yperso;
        this.w=w;
        this.h=h;
        hitbox=new Rectangle2D(xperso,yperso,w,h);
        Image spriteSheet = new Image(filename);
        sprite = new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(index, y, w, h));
        sprite.setX(xperso);
        sprite.setY(yperso);
    }

    public ImageView getSprite() {
        return sprite;
    }

    public Rectangle2D getHitbox(){
        return hitbox;
    }

    public void setHitbox(Rectangle2D hitbox) {
        this.hitbox = hitbox;
    }
}
