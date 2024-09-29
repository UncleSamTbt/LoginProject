/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginproject;

/**
 *
 * @author samuk
 */
public class Login {
    // Variables for storing user data
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    // Constructor used to set up user information
    public Login(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    // Method for verifying the correct format of the username
    public boolean checkUserName() {
        // Username must contain an underscore and be no more than 5 characters long
        return username.contains("_") && username.length() <= 5;
    }

    // Method for verifying if the password satisfies complexity standards
    public boolean checkPasswordComplexity() {
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasNumber = password.matches(".*\\d.*");
        boolean hasSpecialChar = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
        return password.length() >= 8 && hasUppercase && hasNumber && hasSpecialChar;
    }

    // Method for managing registration messages through examination checks
    public String registeredUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        }
        return "Username and Password successfully captured. User registered!";
    }

    // Method to confirm if the login credentials correspond to the registration information
    public boolean loginUser(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    // Method to return login status notification
    public String returnLoginStatus(String inputUsername, String inputPassword) {
        if (loginUser(inputUsername, inputPassword)) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again!";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
