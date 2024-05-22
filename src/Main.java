import Login.UserCredentials;
import Login.Login;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Login login = new Login();
        String firstName = JOptionPane.showInputDialog("Enter first name:");
        String lastName = JOptionPane.showInputDialog("Enter last name:");

        login.setFirstName(firstName);
        login.setLastName(lastName);
        String username = "";
        String password = "";

        String registrationStatus = "";
        while (!registrationStatus.contains("success")) {
            username = JOptionPane.showInputDialog("Enter username:");
            password = JOptionPane.showInputDialog("Enter password:");

            registrationStatus = login.registerUser(username, password);
            JOptionPane.showMessageDialog(null, registrationStatus);
        }
        login.setUsername(username);
        login.setPassword(password);


        while (!login.loginUser()) {}
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
        while (login.returnLoginStatus().compareTo("success") == 0) {}

        UserCredentials userCredentials = new UserCredentials();
        userCredentials.option();
    }
}