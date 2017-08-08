package design_patterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miha on 08.08.2017.
 */
public class MediatorApp {
    public static void main(String[] args) {
        TextChat chat = new TextChat();

        User admin = new Admin(chat);
        User user1 = new SimpleUser(chat);
        User user2 = new SimpleUser(chat);

        chat.setAdmin(admin);
        chat.addUser(user1);
        chat.addUser(user2);

        user1.sendMessage("Hello im user");
        admin.sendMessage("Admin is online");
    }
}

interface User {
    void sendMessage(String message);
    void getMessage(String message);
}

interface Chat {
    void sendMessage(String message, User user);
}

class Admin implements User {

    Chat chat;

    public Admin(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("Admin get message: " + message);
    }
}

class SimpleUser implements User {
    Chat chat;

    public SimpleUser(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("User get message: " + message);
    }
}

class TextChat implements Chat {
    User admin;
    List<User> users = new ArrayList<>();

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public void addUser(User u) {
        users.add(u);
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User u : users){
            u.getMessage(message);
        }
        admin.getMessage(message);
    }
}