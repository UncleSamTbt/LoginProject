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
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    // Register the user with provided details
    public String registerUser(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;

        if (!checkUserName()) {
            return "Username is not correctly formatted. It must contain an underscore and be no more than 5 characters.";
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted. It must contain at least 8 characters, a capital letter, a number, and a special character.";
        }
        return "User registered successfully!";
    }

    // Verify username format
    private boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }

    // Verify password complexity
    private boolean checkPasswordComplexity() {
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasNumber = password.matches(".*\\d.*");
        boolean hasSpecialChar = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
        return password.length() >= 8 && hasUppercase && hasNumber && hasSpecialChar;
    }

    // Validate login credentials
    public boolean loginUser(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }
}