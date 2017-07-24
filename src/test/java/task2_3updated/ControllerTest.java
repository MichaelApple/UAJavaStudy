package task2_3updated;

import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by Miha on 24.07.2017.
 */
public class ControllerTest {

    Model model;
    View view;
    Controller controller;
    Scanner scanner;

    @Before
    public void init() {
        model = new Model();
        view = new View();
        controller = new Controller(model, view);
        scanner = new Scanner(System.in);
    }

    @Test
    public void setRandomNumber() throws Exception {
        assertNotNull(controller.setRandomNumber(0, 100));
    }

    @Test
    public void testRanges() throws Exception {
        assertTrue(controller.setRandomNumber(0, 100) > 0 && controller.setRandomNumber(0, 100) < 100);
    }
}