package design_patterns.creational.abstract_factory;

/**
 * Created by Miha on 03.08.2017.
 */
public class AbstractFactory {
    public static void main(String[] args) {
        DeviceFactory factory = getFactoryByCountryCode("UA");

        Mouse m = factory.getMouse();
        Keyboard k = factory.getKeyboard();
        TouchPad touchPad = factory.getTouchPad();

        m.click();
        k.println();
        touchPad.track(5, 7);
    }

    public static DeviceFactory getFactoryByCountryCode(String lang) {
        switch (lang) {
            case "UA":
                return new UADeviceFactory();
            case "EN":
                return new ENDeviceFactory();
            default: throw new RuntimeException("Unsupported Country Code: " + lang);
        }
    }
}
interface Mouse {
    void click();
    void dblclick();
    void scroll(int direction);
}
interface Keyboard {
    void print();
    void println();
}
interface TouchPad {
    void track(int x, int y);
}

interface DeviceFactory {
    Mouse getMouse();
    Keyboard getKeyboard();
    TouchPad getTouchPad();
}

class UAMouse implements Mouse {

    @Override
    public void click() {
        System.out.println("Клік");
    }

    @Override
    public void dblclick() {
        System.out.println("Подвійний Клік");
    }

    @Override
    public void scroll(int direction) {
        System.out.println("Міняємо напрямок");
    }
}

class UAKeyboard implements Keyboard {
    @Override
    public void print() {
        System.out.print("Прінт");
    }

    @Override
    public void println() {
        System.out.println("Прінт з нової лінії");
    }
}

class UATouchPad implements TouchPad {
    @Override
    public void track(int x, int y) {
        int s = (int) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        System.out.println("Перемістились на " + s + " пікселів");
    }
}

class ENMouse implements Mouse {

    @Override
    public void click() {
        System.out.println("Click");
    }

    @Override
    public void dblclick() {
        System.out.println("Double click");
    }

    @Override
    public void scroll(int direction) {
        System.out.println("Change direction");
    }
}

class ENKeyboard implements Keyboard {
    @Override
    public void print() {
        System.out.print("Print");
    }

    @Override
    public void println() {
        System.out.println("Print new line");
    }
}

class ENTouchPad implements TouchPad {
    @Override
    public void track(int x, int y) {
        int s = (int) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        System.out.println("moving on  " + s + " pixels");
    }
}

class UADeviceFactory implements DeviceFactory {
    @Override
    public Mouse getMouse() {
        return new UAMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new UAKeyboard();
    }

    @Override
    public TouchPad getTouchPad() {
        return new UATouchPad();
    }
}

class ENDeviceFactory implements DeviceFactory {
    @Override
    public Mouse getMouse() {
        return new ENMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new ENKeyboard();
    }

    @Override
    public TouchPad getTouchPad() {
        return new ENTouchPad();
    }
}