import javafx.geometry.Rectangle2D;

public class Bat extends AnimatedThing {
    private double offset = 130;

    public Bat(double xperso, double yperso, double index, double y, double w, double h, String filename, String attitude) {
        super(xperso, yperso, index, y, w, h, filename, attitude);
    }

    public void update(double time, double vcam) {
        if (this.index ==0) {
            sprite.setViewport(new Rectangle2D(index, 0, offset, 62));
            this.xperso -= 1.5*vcam * time;
            this.getSprite().setX(xperso);
            this.getSprite().setY(yperso);
            hitbox = new Rectangle2D(xperso + 12, yperso, 106, 62);
            this.index += offset;
        } else if(this.index==offset) {
            sprite.setViewport(new Rectangle2D(index, 0, offset, 62));
            this.xperso -= 1.5 * vcam * time;
            this.getSprite().setX(xperso);
            this.getSprite().setY(yperso);
            hitbox = new Rectangle2D(xperso + 30, yperso, 87, 62);
            this.index += offset;
        }else if(this.index==2*offset) {
            sprite.setViewport(new Rectangle2D(index, 0, offset, 62));
            this.xperso -= 1.5*vcam * time;
            this.getSprite().setX(xperso);
            this.getSprite().setY(yperso);
            hitbox = new Rectangle2D(xperso + 31, yperso, 67, 62);
            this.index += offset;
        } else if(this.index==3*offset){
            sprite.setViewport(new Rectangle2D(index, 0, offset, 62));
            this.xperso -= 1.5*vcam * time;
            this.getSprite().setX(xperso);
            this.getSprite().setY(yperso);
            hitbox = new Rectangle2D(xperso +31, yperso, 87, 62);
            this.index=0;
        }
        if (xperso < 0) {
            xperso = 800 + Math.random() * 1000;
            if(yperso>=120&&yperso<170){
                yperso +=Math.random()*50;
                System.out.println("augmente");
            }else if(yperso>170){
                yperso -=Math.random()*50;
                System.out.println("descend");
            }else if(yperso<130){
                yperso=150;
            }
        }
    }
}