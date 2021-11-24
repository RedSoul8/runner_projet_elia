import javafx.geometry.Rectangle2D;

public class Foe extends AnimatedThing {
    private double offset=80;
    public Foe(double xperso, double yperso, double index, double y, double w, double h, String filename, String attitude) {
        super(xperso, yperso, index, y, w, h, filename, attitude);
    }
    public void update(double time, double vcam, long now) {
        if (this.index < 720) {
            this.index += offset;
        } else {
            this.index = 0;
        }
        sprite.setViewport(new Rectangle2D(index, 0, offset, 102));
        this.xperso -= vcam * time;
        this.getSprite().setX(xperso);
        hitbox = new Rectangle2D(xperso-14, 235, offset-40, 70);
        System.out.println("temps "+now*Math.pow(10,-9));
        System.out.println("quand "+time*Math.random()*10);
       /* if(now*Math.pow(10,-9)==time*Math.random()*10){
AAAAAAAAAAAAAAAAAAAAAAh je sais pas comment gérer le temps d'app entre 2 foes ....
        }*/
    }
}

