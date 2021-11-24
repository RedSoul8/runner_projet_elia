import javafx.geometry.Rectangle2D;

import java.util.Objects;

public class Hero extends AnimatedThing {
    private double offset = 48;
    private double invisibility = 0;

    public Hero(double xhero, double yhero, double index, double y, double w, double h, String filename, String attitude) {
        super(xhero, yhero, index, y, w, h, filename, attitude);
    }

    public void update(double time, double v0, Camera camera) {
        double ay;
        double vy = v0;
        double g = 10;

        if (Objects.equals(this.attitude, "running")) {
            if (this.index < 5*offset) { //annimation de course
                this.index += offset;
            } else {
                this.index = 0;
            }
            xperso += 20; //mon hero avance
            sprite.setViewport(new Rectangle2D(index, 0, offset, 48));
            sprite.setX(xperso - camera.getX() + 20);
            this.setHitbox(new Rectangle2D(xperso - camera.getX() + 21, yperso+1, offset-6, 46));
        }
        if (Objects.equals(this.attitude, "jumping up")) {
            if (index<3*offset) { // annimation élan avant le saut
                index += offset;
                xperso += 20;
            }
            else {
                if (this.yperso > 160) { //phase montante du saut
                    System.out.println("saute !");
                    if (accelerate) { //cas où le hero accelère
                        ay = -g * 0.001;
                        vy += ay * time;
                        yperso -= vy * time;
                        xperso += 45;
                    } else { // cas normal
                        ay = -g;
                        vy += ay * time;
                        yperso -= vy * time;
                        xperso += 25;
                        System.out.println(vy+" , "+yperso);
                    }
                } else { //annimation avant la redescente
                    index+=offset;
                    this.attitude = "jumping down";
                    System.out.println("tombe !");
                }
            }
            sprite.setViewport(new Rectangle2D(index, 48, offset, 48));
            sprite.setX(xperso - camera.getX()+20);
            sprite.setY(yperso);
            this.setHitbox(new Rectangle2D(xperso - camera.getX() + 21, yperso+1, offset-6, 46));        }
        if (Objects.equals(this.attitude, "jumping down")) {
            if (this.yperso < 259) { //phase descendante du saut
                index = 240;
                if (accelerate) { //cas où le hero accelère
                    ay = -g * 0.001;
                    vy += ay * time;
                    yperso += vy * time;
                    xperso += 20;
                } else { // cas normal
                    ay = -g;
                    vy += ay * time;
                    yperso += vy * time;
                }
            } else {
                if(index<6*offset){ //annimation atterrissage
                    System.out.println("touche le sol..");
                    yperso = 260;
                    index += offset;
                }
                else{ //retour à la course
                    index = 0;
                    this.attitude = "running";
                }
            }
            sprite.setViewport(new Rectangle2D(index, 48, offset, 48));
            xperso += 25;
            sprite.setX(xperso - camera.getX()+20);
            sprite.setY(yperso);
            this.setHitbox(new Rectangle2D(xperso - camera.getX() + 21, yperso+1, offset-6, 46));        }
        if (Objects.equals(this.attitude, "hurt")){
            if (invisibility>0){
                invisibility -= time;
                if(index<3*offset){
                    index+=offset;
                }else{
                    index=0;
                }
            }
            else{
                attitude="running";
                invisibility=0;
            }
            xperso += 13; //mon hero avance
            sprite.setViewport(new Rectangle2D(index, 96, offset, 48));
            sprite.setX(xperso - camera.getX() + 20);
            yperso=260;
            sprite.setY(yperso);
            this.setHitbox(new Rectangle2D(xperso - camera.getX() + 21, yperso+1, offset-6, 46));
        }
        if (Objects.equals(this.attitude, "death")){
            if(index<8*offset) {
                index += offset;
            }
            xperso += 20; //mon hero avance
            sprite.setViewport(new Rectangle2D(index, 144, offset, 48));
            sprite.setX(xperso - camera.getX() + 20);
            sprite.setY(260);
        }
    }

    public Boolean IsInvisible() {
        return invisibility>0;
    }

    public void setInvisibility(double invisibility) {
        this.invisibility = invisibility;
    }
}

