package Login;

import javax.swing.JOptionPane;

import Tasks.Tasks;

public class Login2 {

    public static void login() {

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

        UserCredentials userCredentials = new UserCredentials();
        Tasks tasks = new Tasks();
        int total = 0;
        while (!login.loginUser()) {}
        while (true) {
            userCredentials.option();
        }
        
    }
}
