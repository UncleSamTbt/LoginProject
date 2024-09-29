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
    // Variables to store user information
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    // Constructor for initializing user details
    public Login(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    // Method to check if the username is correctly formatted
    public boolean checkUserName() {
        // Username must contain an underscore and be no more than 5 characters long
        return username.contains("_") && username.length() <= 5;
    }

    // Method to check if the password meets complexity requirements
    public boolean checkPasswordComplexity() {
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasNumber = password.matches(".*\\d.*");
        boolean hasSpecialChar = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
        return password.length() >= 8 && hasUppercase && hasNumber && hasSpecialChar;
    }

    // Method to handle registration messages based on checks
    public String registeredUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        }
        return "Username and Password successfully captured. User registered!";
    }

    // Method to verify if the login details match the registration details
    public boolean loginUser(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    // Method to return login status message
    public String returnLoginStatus(String inputUsername, String inputPassword) {
        if (loginUser(inputUsername, inputPassword)) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again!";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
