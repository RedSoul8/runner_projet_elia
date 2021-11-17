import javafx.geometry.Rectangle2D;

import java.util.Objects;

public class Hero extends AnimatedThing {
    public Hero(double xhero, double yhero, double index, double y, double w, double h, String filename, String attitude) {
        super(xhero, yhero, index, y, w, h, filename, attitude);
    }

    public void update(double time, double v0,Camera camera) {
        double ay;
        double vy=v0;
        double g=10;
        double alph=0.7;

        if (Objects.equals(this.attitude, "running")) {
            if (this.index < max_index) {
                this.index = this.index + 85;
            }
            else{
                this.index=0;
            }
            xperso +=20;
            sprite.setViewport(new Rectangle2D(index, 0, 85, 100));
            sprite.setX(xperso-camera.getX()+10);
            this.setHitbox(new Rectangle2D(xperso-camera.getX()+10,yperso,85,100));
        }
        if (Objects.equals(this.attitude, "jumping up")){
            if(this.yperso>110){
                //System.out.println("saute !");
                if(accelerate){
                    ay=-g*0.001;
                    //vy=ay*time+v0*Math.sin(alph);
                    //yhero-=-1/2*ay*time*time+v0*Math.sin(alph)*time;
                    vy+=ay*time;
                    yperso-=vy*time;
                    xperso+=20;
                }
                else{
                    ay=-g;
                    vy+=ay*time;
                    yperso-=vy*time;
                }
                this.index=0;
            }
            else{
                this.attitude="jumping down";
            }
            sprite.setViewport(new Rectangle2D(index, 163, 85, 100));
            xperso +=15;
            sprite.setX(xperso-camera.getX()+30);
            sprite.setY(yperso);
            this.setHitbox(new Rectangle2D(xperso-camera.getX()+10,yperso,85,100));
        }
        if (Objects.equals(this.attitude, "jumping down")){
            if(this.yperso<210){
                if(accelerate){
                    ay=-g*0.001;
                    //vy=ay*time+v0*Math.sin(alph);
                    //yhero+=-1/2*ay*Math.pow(time,2)+v0*Math.sin(alph)*time;
                    vy+=ay*time;
                    yperso+=vy*time;
                    xperso+=20;
                    this.index=85;
                }
                else{
                    ay=-g;
                    //vy=ay*time+v0*Math.sin(alph);
                    //yhero+=-1/2*ay*Math.pow(time,2)+v0*Math.sin(alph)*time;
                    vy+=ay*time;
                    yperso+=vy*time;
                    this.index=85;
                }
            }
            else{
                yperso=210;
                this.attitude="running";
            }
            sprite.setViewport(new Rectangle2D(index, 163, 85, 100));
            xperso +=20;
            sprite.setX(xperso-camera.getX()+30);
            sprite.setY(yperso);
            this.setHitbox(new Rectangle2D(xperso-camera.getX()+10,yperso,85,100));
        }
    }
}

