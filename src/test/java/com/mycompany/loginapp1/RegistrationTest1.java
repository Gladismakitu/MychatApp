package com.mycompany.loginapp1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class RegistrationTest1 {

    private final Registration1 validReg = new Registration1(
            "kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");

    @Test
    public void testRegisterUser_UsernameCorrect_ReturnsWelcomeMessage() {
        assertEquals(
            "Welcome Kyle ,Smith it is great to see you.",
            validReg.registerUser()
        );
    }

    @Test
    public void testRegisterUser_UsernameIncorrect_ReturnsUsernameError() {
        Registration1 reg = new Registration1(
                "kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertEquals(
            "Username is not correctly formatted; please ensure that your username " +
            "contains an underscore and is no more than five characters in length.",
            reg.registerUser()
        );
    }

    @Test
    public void testRegisterUser_PasswordCorrect_ReturnsWelcomeMessage() {
        assertEquals(
            "Welcome Kyle ,Smith it is great to see you.",
            validReg.registerUser()
        );
    }

    @Test
    public void testRegisterUser_PasswordIncorrect_ReturnsPasswordError() {
        Registration1 reg = new Registration1(
                "kyl_1", "password", "+27838968976", "Kyle", "Smith");
        assertEquals(
            "Password is not correctly formatted; please ensure that the password " +
            "contains at least eight characters, a capital letter, a number, and a special character.",
            reg.registerUser()
        );
    }

    @Test
    public void testCheckCellPhoneNumber_Correct_ReturnsTrue() {
        assertTrue(validReg.checkCellPhoneNumber());
    }

    @Test
    public void testCheckCellPhoneNumber_Incorrect_ReturnsFalse() {
        Registration1 reg = new Registration1(
                "kyl_1", "Ch&&sec@ke99!", "08966553", "Kyle", "Smith");
        assertFalse(reg.checkCellPhoneNumber());
    }

    @Test
    public void testLoginUser_Successful_ReturnsTrue() {
        Login1 login = new Login1("kyl_1", "Ch&&sec@ke99!", validReg);
        assertTrue(login.loginUser());
    }

    @Test
    public void testLoginUser_Failed_ReturnsFalse() {
        Login1 login = new Login1("kyl_1", "WrongPassword1!", validReg);
        assertFalse(login.loginUser());
    }

    @Test
    public void testCheckUserName_CorrectlyFormatted_ReturnsTrue() {
        assertTrue(validReg.checkUserName());
    }

    @Test
    public void testCheckUserName_IncorrectlyFormatted_ReturnsFalse() {
        Registration1 reg = new Registration1(
                "kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertFalse(reg.checkUserName());
    }

    @Test
    public void testCheckPasswordComplexity_MeetsComplexity_ReturnsTrue() {
        assertTrue(validReg.checkPasswordComplexity());
    }

    @Test
    public void testCheckPasswordComplexity_DoesNotMeetComplexity_ReturnsFalse() {
        Registration1 reg = new Registration1(
                "kyl_1", "password", "+27838968976", "Kyle", "Smith");
        assertFalse(reg.checkPasswordComplexity());
    }
}
