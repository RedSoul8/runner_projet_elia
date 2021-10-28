import javafx.geometry.Rectangle2D;

public class Hero extends AnimatedThing {
    public Hero(double posx, double posy, double index, double y, double w, double h, String filename, String attitude) {
        super(posx, posy, index, y, w, h, filename, attitude);
    }

    public void update(long now) {
        if (this.attitude == "running") {
            if (this.index < max_index) {
                this.index = this.index + 85;
            }
            else{
                this.index=0;
            }

            sprite.setViewport(new Rectangle2D(index, 0, 85, 100));
        }
    }
}

