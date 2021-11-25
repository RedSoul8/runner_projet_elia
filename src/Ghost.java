import javafx.geometry.Rectangle2D;

public class Ghost extends AnimatedThing {
    private double offset=80;
    public Ghost(double xperso, double yperso, double index, double y, double w, double h, String filename, String attitude) {
        super(xperso, yperso, index, y, w, h, filename, attitude);
    }
    public void update(double time, double vcam) {
        if (this.index < 720) {
            this.index += offset;
        } else {
            this.index = 0;
        }
        sprite.setViewport(new Rectangle2D(index, 0, offset, 102));
        this.xperso -= 1.5*vcam * time;
        this.getSprite().setX(xperso);
        hitbox = new Rectangle2D(xperso-18, 250, 47, 66);
        if(xperso<0){
            xperso=2000+Math.random()*100;
        }
        
        /* 
        faire 2 ou 3 méchants , les faires apparaitres avec un minimum + random pour les mettre dans le desordres 
        les faire app séparé de 100 / 200 environ 
         */
    }
}