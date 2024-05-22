package Login;

import javax.swing.*;
import Tasks.Tasks;

public class UserCredentials {

    public void option() {

        String[] options = { "Add Task", "Show report", "Quit" };
        int choice = JOptionPane.showOptionDialog(null, "Choose an option", "Task Manager",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                addTasks();
                break;
            case 1:
                showReport();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "You need to select one of the three options!");
                break;
        }
    }

    public static void addTasks() {

        Tasks tasks = new Tasks();

        String task_Name = JOptionPane.showInputDialog("Enter task name:");
        int task_Number = Integer.parseInt(JOptionPane.showInputDialog("Enter task number:"));
        String task_Description = JOptionPane.showInputDialog("Enter task description (less than 50 characters):");

        if (task_Description.length() > 50) {
            tasks.checkTaskDescription();
        } else {
            JOptionPane.showMessageDialog(null, "Task successfully captured");
        }
    }

    public void showReport() {
         String report = "Coming soon";
         JOptionPane.showMessageDialog(null, report);
    }

}
