public class Camera{

    private double x;
    private double y;
    private double ax;
    private double k_m=4;
    private double f_m=3;
    private double vx=0;

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

    public double getA() {
        return ax;
    }

    public void update(double time, double xhero)  {
        if(time<1){
            System.out.println("ax "+ ax);
            System.out.println("vx "+ vx);
            System.out.println("x "+ x);
            System.out.println("time "+time);
            ax=k_m*(xhero-x)-f_m*vx;
            vx+=ax*time;
            x+=vx*time;
        }
    }
}
