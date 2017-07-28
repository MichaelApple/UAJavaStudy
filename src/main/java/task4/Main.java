package task4;


import task4.controller.Controller;
import task4.model.Model;
import task4.view.View;

/**
 * Created by Miha on 28.07.2017.
 */
public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Controller controller = new Controller(new Model(), new View());

        controller.processUser();
    }
}
