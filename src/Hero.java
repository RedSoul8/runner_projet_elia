import javafx.geometry.Rectangle2D;

public class Hero extends AnimatedThing {
    public Hero(double xhero, double yhero, double index, double y, double w, double h, String filename, String attitude) {
        super(xhero, yhero, index, y, w, h, filename, attitude);
    }

    public void update(double time, double xcam, double v0) {
        double ay;
        double vy=v0;
        double g=10;
        double alph=0.7;
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
        if (this.attitude=="jumping up"){
            if(this.yhero>150){
                ay=-g;
                //vy=ay*time+v0*Math.sin(alph);
                //yhero-=-1/2*ay*time*time+v0*Math.sin(alph)*time;
                vy+=ay*time;
                yhero-=vy*time;
                System.out.println("yhero "+this.yhero);
                System.out.println("if");
                this.index=0;
            }
            else{
                this.attitude="jumping down";
            }
            sprite.setViewport(new Rectangle2D(index, 163, 85, 100));
            sprite.setX(xhero-xcam+130);
            sprite.setY(yhero);
            xhero +=20;
        }
        if (this.attitude=="jumping down"){
            if(this.yhero<270){
                ay=g;
                //vy=ay*time+v0*Math.sin(alph);
                //yhero+=-1/2*ay*Math.pow(time,2)+v0*Math.sin(alph)*time;
                vy+=ay*time;
                yhero+=vy*time;
                this.index=85;
            }
            else{
                yhero=270;
                this.attitude="running";
            }
            sprite.setViewport(new Rectangle2D(index, 163, 85, 100));
            sprite.setX(xhero-xcam+130);
            sprite.setY(yhero);
            xhero +=20;
        }
    }
}

