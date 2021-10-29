public class Camera{
    private double x;
    private double y;
    private double a;
    private double k_m;
    private double f_m;
    private double v;

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

    public double getY() {
        return y;
    }

    public void update(long time, double xhero)  {
        a=k_m*(xhero-x)-f_m*v;
        v=a*time;
        x=v*time;
    }
}
