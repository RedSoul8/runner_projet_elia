import javafx.geometry.Rectangle2D;

public class Health extends AnimatedThing {
    protected double nboflife=3;
    public Health(double xheart, double yheart, double index, double y, double w, double h, String filename, String attitude) {
        super(xheart, yheart, index, y, w, h, filename, attitude);
    }

    public void update(double time) {
        if ( nboflife == 2) {
            sprite.setViewport(new Rectangle2D(29, 0, 87, 27));
        } else if (nboflife == 1) {
            sprite.setViewport(new Rectangle2D(58, 0, 87, 27));
        } else if (nboflife == 0){
            sprite.setViewport(new Rectangle2D(87, 0, 87, 27));
        }
        sprite.setX(500);
        this.getSprite().setX(xperso);
    }
}


