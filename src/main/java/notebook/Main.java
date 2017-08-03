package notebook;


import notebook.controller.Controller;
import notebook.model.Model;
import notebook.view.View;

/**
 * Created by Miha on 28.07.2017.
 */
public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Controller controller = new Controller(new Model(), new View());

        controller.processUser();
    }
}
