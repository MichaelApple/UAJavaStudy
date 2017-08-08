package design_patterns.creational.template_method;

/**
 * Created by Miha on 08.08.2017.
 */
public class TemplateMethod {
    public static void main(String[] args) {
        A a = new A();
        a.templateMethod();

        System.out.println();

        B b = new B();
        b.templateMethod();
    }
}

abstract class C {
    void templateMethod() {
        System.out.println(1);
        differ();
        System.out.println(3);
    }

    abstract void differ();
}

class A extends C{
    @Override
    void differ() {
        System.out.println(2);
    }
}

class B extends C{
    @Override
    void differ() {
        System.out.println(4);
    }
}