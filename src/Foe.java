import javafx.geometry.Rectangle2D;

public class Foe extends AnimatedThing {
    public Foe(double xperso, double yperso, double index, double y, double w, double h, String filename, String attitude) {
        super(xperso, yperso, index, y, w, h, filename, attitude);
    }
    public void update(double time, double vcam) {
        //if (attitude=="alive"){
        if (this.index < 450) {
            this.index = this.index + 45;
        } else {
            this.index = 8;
        }
        sprite.setViewport(new Rectangle2D(index, 0, 45, 70));
        sprite.setX(500);
        this.xperso -= vcam * time;
        this.getSprite().setX(xperso);
        this.setHitbox(new Rectangle2D(xperso, 0, 45, 70));
        //}
        /*if (attitude=="dead"){

        }*/
    }
}
