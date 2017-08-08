package design_patterns.structural;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miha on 05.08.2017.
 */
public class CompositeApp {
    public static void main(String[] args) {
        Shape circle = new CircleComposite();
        Shape triangle = new TriangleComposite();
        Shape square = new SquareComposite();

        Composite composite = new Composite();
        composite.addComponent(circle);
        composite.addComponent(circle);
        composite.addComponent(triangle);

        composite.draw();
    }
}
interface Shape {
    void draw();
}

class SquareComposite implements Shape {
    @Override
    public void draw() {
        System.out.println("Square");
    }
}
class TriangleComposite implements Shape {
    @Override
    public void draw() {
        System.out.println("Triangle");
    }
}
class CircleComposite implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}

class Composite implements Shape {
    private List<Shape> components = new ArrayList<>();

    public void addComponent(Shape shape){
        components.add(shape);
    }
    public void removeComponent(Shape shape){
        components.remove(shape);
    }

    @Override
    public void draw() {
        for(Shape component : components) {
            component.draw();
        }
    }
}