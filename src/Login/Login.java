package Login;


import javax.swing.*;

public class Login {

    String status = "fail";
    String username;
    String password;
    String firstName;
    String lastName;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean checkUserName(String username) {
        return username != null && username.length() <= 5 && username.contains("_");
    }

    public boolean checkPasswordComplexity(String password) {
        return password != null && password.length() >= 8 && password.matches(".*[A - Z]*.") && password.matches(".*[!@#$%^&*()].*") && password.matches(".*\\d*.");
    }

    public String registerUser(String username, String password) {

        boolean isUserNameValid = checkUserName(username);
        boolean isPasswordValid = checkPasswordComplexity(password);

        if(!isUserNameValid && !isPasswordValid){
            return "Both are not valid";
        } else if(!isUserNameValid){
            return "Username is not correctly formatted, please ensure that your username contains an underscore and no more than 5 characters in length";
        } else if (!isPasswordValid) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }
        else {
            return "User successfully registered";
        }
    }

    public boolean loginUser() {

            String log_username = JOptionPane.showInputDialog("Enter username:");
            String log_password = JOptionPane.showInputDialog("Enter password:");

            //Confirm or check stored credentials
            if (log_username.compareTo(username) == 0 && log_password.compareTo(password) == 0) {
                JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
                //Loop stops when loginInput is true
                status = "success";

                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again");
                status = "fail";
                return false;
            }
        //Loop until successful login

    }
    public String returnLoginStatus() {
        return status;
    }
}
