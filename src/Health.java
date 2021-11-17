import javafx.geometry.Rectangle2D;

public class Health extends AnimatedThing {
    protected double nboflife=3;
    public Health(double xheart, double yheart, double index, double y, double w, double h, String filename, String attitude) {
        super(xheart, yheart, index, y, w, h, filename, attitude);
    }

    public void update(double time) {
        if ( nboflife == 2) {
            this.index = this.index + 29;
        } else if (nboflife == 1) {
            this.index = this.index + 29;
        } else if (attitude == "dead"){
            this.index = this.index + 29;
        }
        sprite.setViewport(new Rectangle2D(index, 0, 45, 70));
        sprite.setX(500);
        this.getSprite().setX(xperso);
    }
}


