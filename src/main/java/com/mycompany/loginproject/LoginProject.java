/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginproject;

import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author samuk
 */
public class LoginProject {

    
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        int totalHours = 0;

        // User registration with JOptionPane
        String firstName = JOptionPane.showInputDialog("Enter your first name:");
        String lastName = JOptionPane.showInputDialog("Enter your last name:");
        String username = JOptionPane.showInputDialog("Enter a username (with underscore, max 5 characters):");
        String password = JOptionPane.showInputDialog("Enter a password (at least 8 characters, with a capital letter, number, and special character):");

        // Register the user
        Login user = new Login();
        String registrationMessage = user.registerUser(firstName, lastName, username, password);
        JOptionPane.showMessageDialog(null, registrationMessage);

        // Login attempt
        String loginUsername = JOptionPane.showInputDialog("Enter your username:");
        String loginPassword = JOptionPane.showInputDialog("Enter your password:");

        // Validate login
        if (user.loginUser(loginUsername, loginPassword)) {
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban!");

            // Main menu loop
            boolean running = true;
            while (running) {
                String option = JOptionPane.showInputDialog(
                    "Select an Option:\n" +
                    "1) Add Task\n" +
                    "2) Show Report (Coming Soon)\n" +
                    "3) Quit"
                );

                int choice = Integer.parseInt(option); // Convert input to integer

                switch (choice) {
                    case 1:
                        // Add Tasks
                        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to add?"));

                        for (int i = 0; i < numTasks; i++) {
                            String taskName = JOptionPane.showInputDialog("Enter the task name:");

                            // Validate task name length
                            if (taskName.length() < 2) {
                                JOptionPane.showMessageDialog(null, "Task name must be at least 2 characters long.");
                                i--; // Retry this task entry
                                continue;
                            }

                            String taskDescription = JOptionPane.showInputDialog("Enter the task description (max 50 characters):");
                            if (taskDescription.length() > 50) {
                                JOptionPane.showMessageDialog(null, "Description too long! Please keep it under 50 characters.");
                                i--; // Retry this task entry
                                continue;
                            }

                            String developerName = JOptionPane.showInputDialog("Enter the developer's name:");
                            if (developerName.length() < 3) {
                                JOptionPane.showMessageDialog(null, "Developer name must be at least 3 characters long.");
                                i--; // Retry this task entry
                                continue;
                            }

                            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration in hours:"));

                            // Task Status selection using drop-down
                            String[] statusOptions = {"To Do", "Doing", "Done"};
                            String taskStatus = (String) JOptionPane.showInputDialog(
                                null,
                                "Select Task Status:",
                                "Task Status",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                statusOptions,
                                statusOptions[0]
                            );

                            // Handle case when the user cancels the selection
                            if (taskStatus == null) {
                                JOptionPane.showMessageDialog(null, "Task status selection cancelled. Please try again.");
                                i--; // Retry this task entry
                                continue;
                            }

                            // Create and store the task
                            Task task = new Task(taskName, i, taskDescription, developerName, taskDuration, taskStatus);
                            tasks.add(task);
                            totalHours += task.getTaskDuration();

                            // Display task details
                            JOptionPane.showMessageDialog(null, task.printTaskDetails());
                        }

                        // Display total hours
                        JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + totalHours + " hours");
                        break;

                    case 2:
                        // Show Report (placeholder)
                        JOptionPane.showMessageDialog(null, "Coming Soon");
                        break;

                    case 3:
                        // Quit the application
                        JOptionPane.showMessageDialog(null, "Goodbye!");
                        running = false;
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid login. Please try again.");
        }
    }
}

