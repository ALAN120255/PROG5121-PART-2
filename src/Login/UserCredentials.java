package Login;

import javax.swing.*;
import Tasks.Tasks;
import java.awt.*;

public class UserCredentials {

    Tasks tasks = new Tasks();

    private static String taskNames[], taskIDs[], developerDetails[];
    private static String[] taskStatuses;
    private static int taskDuration[];
    private static int taskCount = 0;

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
            default:
                JOptionPane.showMessageDialog(null, "You need to select one of the three options!");
                break;
        }
    }

    public static void addTasks() {

        Tasks tasks = new Tasks();

        int numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog("Number of tasks you want to add?"));

        taskNames = new String[numberOfTasks];
        taskIDs = new String[numberOfTasks];
        taskStatuses = new String[numberOfTasks];
        developerDetails = new String[numberOfTasks];
        taskDuration = new int[numberOfTasks];

        while (taskCount < numberOfTasks) {

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

            String taskStatus[] = new String[] { "To Do", "Done", "Doing" };
            int choice = JOptionPane.showOptionDialog((Component) null, "Select task status", "Task Status",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, taskStatus, taskStatus[0]);
            
            taskNames[taskCount] = task_Name;
            developerDetails[taskCount] = dev_details;
            taskIDs[taskCount] = task_ID;
            taskDuration[taskCount] = durat;
            taskStatuses[taskCount] = taskStatus[choice];

            taskCount++;

            JOptionPane.showMessageDialog(null, "Tasks added successfully added!");

            int continueAdding = JOptionPane.showConfirmDialog(null, "Do you want to add another task?",
                    "Conitinue", JOptionPane.YES_NO_OPTION);

            if (continueAdding != JOptionPane.YES_OPTION) {
                break;
            }
        }
    }

    public void showReport() {
        // Task info display
        while (true) {

            StringBuilder reportOptions = new StringBuilder();
            reportOptions.append("1. Display tasks with the status 'Done'.")
                    .append("\n2. Display the developer and the duration of task with the longest duration.")
                    .append("\n3. Search for task using the task name")
                    .append("\n4. Search for task with the developer assigned to each task.")
                    .append("\n5. Delete task.")
                    .append("\n6. Display full detail of tasks added.")
                    .append("\n7. Exit.");

            int choices = Integer.parseInt(JOptionPane.showInputDialog(reportOptions));

            switch (choices) {

                case 1:
                    displayDoneTasks();
                    break;
                case 2:
                    displayLongestTask();
                    break;
                case 3:
                    searchTaskByName();
                    break;
                case 4:
                    searchTaskByDeveloper();
                    break;
                case 5:
                    deleteTask();
                    break;
                case 6:
                    showAllTasks();
                    break;
                case 7:
                    return; // Exit the report menu
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice! Please select a valid option.");
            }
        }
    }

    private void displayDoneTasks() {

        StringBuilder tasksDone = new StringBuilder();
        for (int x = 0; x < taskCount; x++) {
            if ("Done".equals(taskStatuses[x])) {
                tasksDone.append("Developer details: ").append(developerDetails[x])
                        .append("\nTask Name: ").append(taskNames[x])
                        .append("\nTask Duration: ").append(taskDuration[x])
                        .append("\nTask Status: ").append(taskStatuses[x]);
            }
        }
        JOptionPane.showMessageDialog(null, tasksDone.length() > 0 ? tasksDone.toString() : "Tasks not found!");
    }

    private void displayLongestTask() {

        if (taskCount == 0) {
            JOptionPane.showMessageDialog(null, "No tasks available");
            return;
        }
        //Method used to find the task with the longest duration
        int maxDuration = 0;
        for (int i = 1; i < taskCount; i++) {
            if (taskDuration[i] > taskDuration[maxDuration]) {
                maxDuration = i;
            }
        }

        String longestTask = "Developer details: " + developerDetails[maxDuration]
                + "\nDuration: " + taskDuration[maxDuration];
        JOptionPane.showMessageDialog(null, longestTask);
    }

    private void searchTaskByName() {

        String taskName = JOptionPane.showInputDialog("Enter task name to search:");
        StringBuilder result = new StringBuilder();

        for (int x = 0; x < taskCount; x++) {
            if (taskNames[x].equalsIgnoreCase(taskName)) {
                result.append("Task Name: ").append(taskNames[x])
                .append("\nDeveloper details: ").append(developerDetails[x])
                .append("\nTask Status ").append(taskStatuses[x]);
            }
        }
        JOptionPane.showMessageDialog(null, result.length() > 0 ? result.toString() : "Tasks not found with the name '" + taskName + "'.");
    }

    private void searchTaskByDeveloper() {

        String developerName = JOptionPane.showInputDialog("Enter developer name to search:");
        StringBuilder searchResult = new StringBuilder();

        for (int i = 0; i < taskCount; i++) {
            if (developerDetails[i].equalsIgnoreCase(developerName)) {
                searchResult.append("Task Name:").append(taskNames[i])
                        .append("\nTask Status:").append(taskStatuses[i])
                        .append("\n\n");
            }
        }
        JOptionPane.showMessageDialog(null, searchResult.length() > 0 ? searchResult.toString() : "Tasks not found with the name '" + developerName + "'.");
    }

    private void deleteTask() {

        String taskName = JOptionPane.showInputDialog("Enter task name to delete task:");
        boolean foundTask = false;

        for (int x = 0; x < taskCount; x++) {
            //Using arrays to delete the task searched
            if (taskNames[x].equalsIgnoreCase(taskName)) {
                for (int y = x; y < taskCount - 1; y++) {
                    taskNames[y] = taskNames[y + 1];
                    developerDetails[y] = developerDetails[y + 1];
                    taskIDs[y] = taskIDs[y + 1];
                    taskDuration[y] = taskDuration[y + 1];
                    taskStatuses[y] = taskStatuses[y + 1];
                }
                taskCount--;
                foundTask = true;
                JOptionPane.showMessageDialog(null, "Task '" + taskName + "' successfully deleted.");
                break;
            }
        }
        if (!foundTask) {
            JOptionPane.showMessageDialog(null, "Task not found with the name '" + taskName + "'.");
        }
    }

    private void showAllTasks() {
        //Displays all the tasks added.
        StringBuilder report = new StringBuilder();
        for (int i = 0; i < taskCount; i++) {
            report.append("Task Name:").append(taskNames[i])
                    .append("\nDeveloper Details:").append(developerDetails[i])
                    .append("\nTask ID:").append(taskIDs[i])
                    .append("\nDuration:").append(taskDuration[i])
                    .append("\nTask Status:").append(taskStatuses[i])
                    .append("\n\n");
        }
        JOptionPane.showMessageDialog(null, report.length() > 0 ? report.toString() : "No task available");
    }
}
