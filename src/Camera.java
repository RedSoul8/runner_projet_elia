public class Camera{
    private double x;
    private double y;

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

    public void update(long time) {

    }
}
