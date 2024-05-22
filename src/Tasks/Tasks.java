package Tasks;

import javax.swing.JOptionPane;

public class Tasks {

    private String taskName, taskDescription, developerDetails, taskID, status, taskDetails;
    private int taskDuration, taskNumber, taskStatus, overallTotal, duration, count = 0;

    public Tasks(int taskDuration, int taskNumber, int taskStatus, int overallTotal, int duration, int count) {

    }

    public Tasks() {

        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskID = taskID;
        this.taskDetails = taskDetails;
        this.taskDuration = taskDuration;
        this.taskNumber = taskNumber;
        this.taskStatus = taskStatus;
        this.overallTotal = overallTotal;
        this.duration = duration;
        this.count = count;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getTaskID() {
        return taskID;
    }

    public String getTaskDetails() {
        return taskDetails;
    }

    public int getOverallTotal() {
        return overallTotal;
    }
    public boolean checkTaskDescription() {

        return taskDescription.length() < 50;
    }

    public String createTaskID(String taskName, int count, String developerDetails) {

        taskID = (taskName.substring(0, 2) + ":" + count + ":"
                + developerDetails.substring(developerDetails.length() - 3));
        taskID = taskID.toUpperCase();

        return taskID;
    }

    public String printTaskDetails() {

        switch (this.taskStatus) {
            case 1:
                return "To Do";
            case 2:
                return "Done";
            case 3:
                return "Doing";
        }

        taskDetails = ("Task status:\n" + status + "Developer details:\n" + developerDetails + "Total:\n" + count + "Task name:\n" + taskName + "Task ID:\n" + taskID + "Duration:\n" + duration);

        return status;
    }

    public int returnTotalHours(int overallTotal) {

        int total = 0;

        if (count == 0) {
            total = duration;
        } else if (count >= 1) {
            overallTotal = total + duration;
        }

        return overallTotal;
    }
}
