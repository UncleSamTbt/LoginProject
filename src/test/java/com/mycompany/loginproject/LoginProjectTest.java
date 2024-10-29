/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.loginproject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author samuk
 */
public class LoginProjectTest {

    // ---- Tests for Login Class ----

    @Test
    public void testRegisterUser_ValidCredentials() {
        Login login = new Login();
        String result = login.registerUser("John", "Doe", "john_", "Password1!");
        assertEquals("User registered successfully!", result);
    }

    @Test
    public void testRegisterUser_InvalidUsername() {
        Login login = new Login();
        String result = login.registerUser("John", "Doe", "john", "Password1!");
        assertEquals("Username is not correctly formatted. It must contain an underscore and be no more than 5 characters.", result);
    }

    @Test
    public void testRegisterUser_InvalidPassword() {
        Login login = new Login();
        String result = login.registerUser("John", "Doe", "john_", "pass");
        assertEquals("Password is not correctly formatted. It must contain at least 8 characters, a capital letter, a number, and a special character.", result);
    }

    @Test
    public void testLoginUser_ValidCredentials() {
        Login login = new Login();
        login.registerUser("Jane", "Doe", "jane_", "StrongPass1@");
        assertTrue(login.loginUser("jane_", "StrongPass1@"));
    }

    @Test
    public void testLoginUser_InvalidCredentials() {
        Login login = new Login();
        login.registerUser("Jane", "Doe", "jane_", "StrongPass1@");
        assertFalse(login.loginUser("jane_", "WrongPass"));
    }

    // ---- Tests for Task Class ----

    @Test
    public void testTaskDescription_Valid() {
        Task task = new Task("Code", 1, "Fix bug in the login feature", "Sam", 2, "To Do");
        assertTrue(task.checkTaskDescription());
    }

    @Test
    public void testTaskDescription_Invalid() {
        Task task = new Task("Code", 1, "This description is way too long and exceeds fifty characters!", "Sam", 2, "To Do");
        assertFalse(task.checkTaskDescription());
    }

    @Test
    public void testCreateTaskID() {
        Task task = new Task("Fix", 2, "Resolve issue", "Samuel", 3, "Doing");
        String expectedTaskID = "FI:2:UEL";
        assertEquals(expectedTaskID, task.createTaskID());
    }

    @Test
    public void testPrintTaskDetails() {
        Task task = new Task("Review", 3, "Review code", "Alex", 4, "Done");
        String expectedOutput = 
            "Task Status: Done\n" +
            "Developer: Alex\n" +
            "Task Number: 3\n" +
            "Task Name: Review\n" +
            "Task Description: Review code\n" +
            "Task ID: RE:3:LEX\n" +
            "Task Duration: 4 hours";
        assertEquals(expectedOutput, task.printTaskDetails());
    }

    @Test
    public void testGetTaskDuration() {
        Task task = new Task("Build", 4, "Build project", "Chris", 5, "To Do");
        assertEquals(5, task.getTaskDuration());
    }
}
