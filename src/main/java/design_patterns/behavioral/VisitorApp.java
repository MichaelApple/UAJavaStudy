package design_patterns.behavioral;

/**
 * Created by Miha on 05.08.2017.
 */
public class VisitorApp {
    public static void main(String[] args) {

        Element body = new BodyElement();
        Element engine = new EngineElement();

        Visitor hooligan = new HooliganVisitor();

        body.accept(hooligan);
        engine.accept(hooligan);

    }
}

interface Visitor {
    void visit(EngineElement engine);
    void visit(BodyElement element);
    void visit(CarElement engine);
    void visit(WheelElement element);
}

interface Element {
    void accept(Visitor visitor);
}

class EngineElement implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class BodyElement implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
class WheelElement implements Element {
    private String name;

    public WheelElement(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {

    }
}

class CarElement implements Element {

    Element[] elements;

    public CarElement(Element[] elements) {
        this.elements = new Element[] {new WheelElement("Front Left"), new WheelElement("Front Right"), new WheelElement("Back Right"), new WheelElement("Back Left"), new EngineElement(), new BodyElement()};
    }

    @Override
    public void accept(Visitor visitor) {
        for (Element element : elements)
            element.accept(visitor);
        visitor.visit(this);
    }
}

class HooliganVisitor implements Visitor {
    @Override
    public void visit(EngineElement engine) {
        System.out.println("Start engine");
    }

    @Override
    public void visit(BodyElement element) {
        System.out.println("Something else");
    }

    @Override
    public void visit(CarElement engine) {
        System.out.println("Smoking");
    }

    @Override
    public void visit(WheelElement element) {
        System.out.println("Punch wheel");
    }
}

class MechanicalVisitor implements Visitor {
    @Override
    public void visit(EngineElement engine) {
        System.out.println("Start engine");
    }

    @Override
    public void visit(BodyElement element) {
        System.out.println("Something else");
    }

    @Override
    public void visit(CarElement engine) {
        System.out.println("Repair car");
    }

    @Override
    public void visit(WheelElement element) {
        System.out.println("Repair wheel");
    }
}
