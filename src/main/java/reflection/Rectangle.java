package reflection;

/**
 * Created by Miha on 16.08.2017.
 */
@MyClassAnnotation(name = "Rectangle")
public class Rectangle extends Point implements Shape{

    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    @MyAnnotation(name = "Rectangle move", value = "new Rectangle()")
    public Rectangle move(int i, int j) {
        return new Rectangle(this.getX() + i, this.getY() + j, width, height);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "x=" + this.getX() +
                ", y=" + this.getY() +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
