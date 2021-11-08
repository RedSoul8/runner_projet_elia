import javafx.geometry.Rectangle2D;

public class Hero extends AnimatedThing {
    public Hero(double xhero, double posy, double index, double y, double w, double h, String filename, String attitude) {
        super(xhero, posy, index, y, w, h, filename, attitude);
    }

    public void update(double now, double xcam) {
        if (this.attitude == "running") {
            if (this.index < max_index) {
                this.index = this.index + 85;
            }
            else{
                this.index=0;
            }
            xhero +=20;
            sprite.setViewport(new Rectangle2D(index, 0, 85, 100));
            sprite.setX(xhero-xcam+100);
        }
    }
}

