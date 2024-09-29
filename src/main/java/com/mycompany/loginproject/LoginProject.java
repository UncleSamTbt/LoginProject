/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginproject;

import java.util.Scanner;
/**
 *
 * @author samuk
 */
public class LoginProject {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //user registration
        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Enter username (with underscore and no more than 5 characters): ");
        String username = scanner.nextLine();

        System.out.println("Enter password (at least 8 characters, a capital letter, a number, and a special character): ");
        String password = scanner.nextLine();

        // Create a Login object with user details
        Login user = new Login(firstName, lastName, username, password);

        // Attempt registration and print result
        System.out.println(user.registeredUser());

        // Simulate login attempt
        System.out.println("Enter username to log in: ");
        String loginUsername = scanner.nextLine();

        System.out.println("Enter password to log in: ");
        String loginPassword = scanner.nextLine();

        // Attempt login and print result
        System.out.println(user.returnLoginStatus(loginUsername, loginPassword));
    }
}

