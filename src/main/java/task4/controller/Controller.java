package task4.controller;

import task4.model.Model;
import task4.model.entity.Adress;
import task4.model.entity.Group;
import task4.model.exceptions.LoginAlreadyExist;
import task4.view.View;

import java.util.Map;
import java.util.Scanner;

import static task4.controller.RegExpressions.REG_EXPRSSION_MAP;

/**
 * Created by Miha on 28.07.2017.
 */
public class Controller {

    Model model;
    View view;

    private String firstName;
    private String lastName;
    private String middleName;
    private String nickName;
    private String comment;
    private String group;
    private String homePhone;
    private String cellPhonel;
    private String cellPhone2;
    private String email;
    private String skype;
    private String zip;
    private String city;
    private String street;
    private String buildingNumber;
    private String flat;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() throws NoSuchFieldException, IllegalAccessException {
        Scanner sc = new Scanner(System.in);
        for (Map.Entry<String, String> entry : REG_EXPRSSION_MAP.entrySet()) {
            checkData(sc, entry.getKey(), entry.getValue());
        }
        try {
            model.addUser(firstName, lastName, middleName, nickName, comment, group, homePhone, cellPhonel, cellPhone2, email, skype, zip, city, street, buildingNumber, flat);
        } catch (LoginAlreadyExist loginAlreadyExist) {
            view.printMessage(nickName);
        }
        view.printMessage(model.getUser().toString());
    }

    private void checkData(Scanner sc, String input, String regex) throws NoSuchFieldException, IllegalAccessException {

        String result;

        while (true) {
            view.inputData(input, regex);
            result = sc.nextLine();
            if (result.matches(regex)) {
                getClass().getDeclaredField(input).set(this, result);
                return;
            } else view.printWrongInput();
        }
    }
}
