package reflection;

/**
 * Created by Miha on 17.08.2017.
 */
public interface Shape {
    Shape move(int i, int j);
    int getWidth();
    int getHeight();
    void setWidth(int x);
    void setHeight(int y);
}
