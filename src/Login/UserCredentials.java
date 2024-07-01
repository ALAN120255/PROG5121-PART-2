package Login;
import javax.swing.*;
import Tasks.Tasks;
import java.awt.*;

public class UserCredentials {

    Tasks tasks = new Tasks();

    private static String taskNames[], taskIDs[], developerDetails[];
    private static String[] taskStatus;
    private static int taskDuration[];
    private static int taskCount = 0;

    public void option() {

        int taskDuration[];
        taskNames = new String[taskCount];
        taskIDs = new String[taskCount];
        taskStatus = new String[taskCount];
        developerDetails = new String[taskCount];
        taskDuration = new int[taskCount];

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
            default:
                JOptionPane.showMessageDialog(null, "You need to select one of the three options!");
                break;
        }
    }

    public static void addTasks() {

        Tasks tasks = new Tasks();

        while (true) {

            String task_Name = JOptionPane.showInputDialog("Enter task name:");
            int task_Number = Integer.parseInt(JOptionPane.showInputDialog("Enter task number:"));
            String task_Description = JOptionPane.showInputDialog("Enter task description (less than 50 characters):");

            if (task_Description.length() > 50) {
                tasks.checkTaskDescription();
            } else {
                JOptionPane.showMessageDialog(null, "Task successfully captured");
            }

            String dev_details = JOptionPane.showInputDialog("Enter developer details:");
            int durat = Integer.parseInt(JOptionPane.showInputDialog("Enter duration:"));

            String task_ID = tasks.createTaskID(task_Name, task_Number, dev_details);

            JOptionPane.showMessageDialog(null, task_ID);

            String[] taskStatus = new String[] { "To Do", "Done", "Doing" };
            int choice = JOptionPane.showOptionDialog((Component) null, "Select task status", "Task Status",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, taskStatus, taskStatus[0]);
            switch (choice) {
                case 0:
                    JOptionPane.showMessageDialog(null, "To Do");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Done");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Doing");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Unset");
                    break;
            }

            task_Name = taskNames[taskCount];
            dev_details = developerDetails[taskCount];
            task_ID = taskIDs[taskCount];
            durat = taskDuration[taskCount];

            taskCount++;

            JOptionPane.showMessageDialog(null, "Tasks added successfully added!");
        }
    }

    public void showReport() {
        String report = "Coming soon";
        JOptionPane.showMessageDialog(null, report);
    }
}
