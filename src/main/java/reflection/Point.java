package reflection;

/**
 * Created by Miha on 16.08.2017.
 */
@MyClassAnnotation(name = "Point")
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @MyAnnotation(name = "Point move", value = "new Point()")
    public Point move(int i, int j) {
        return new Point(this.x + i, this.y + j);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
