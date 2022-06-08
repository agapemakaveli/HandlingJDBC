package test;

import datos.UserDAO;
import domain.User;

import java.util.ArrayList;
import java.util.List;

public class TestHandlingUsers {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        //Inserting a new user
        //User userNew = new User("Tenet", "");
        //userDAO.insert(userNew);

        //Updating a existing user
        User userModified = new User(3, "Tenet", "741");
        userDAO.update(userModified);

        //Deleting a user
        //userDAO.delete(new User(3));

        List<User> users = userDAO.select();
        users.forEach(person -> {
            System.out.println("User inside lambda: " + person);
        });
    }

    //End of the class
}
