public class Camera{

    private double x;
    private double y;
    protected double ax;
    protected double vx=0;
    private double k_m=4;
    private double f_m=3;

    public Camera(double x, double y){
        this.x=x;
        this.y=y;
    }
    @Override
    public String toString() {
        return "Camera{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getV() {
        return vx;
    }

    public void setAx(double ax) {
        this.ax = ax;
    }

    public double getAx() {
        return ax;
    }

    public void update(double time, double xhero)  {
        if(time<1){
            ax=k_m*(xhero-x)-f_m*vx;
            vx+=ax*time;
            x+=vx*time;
        }
    }
}
