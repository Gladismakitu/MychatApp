/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginapp1;

/**
 *
 * @author Student
 */
import java.util.Scanner;

public class LoginApp1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ── Username ──────────────────────────────────────────────────────────
        String username;
        while (true) {
            System.out.print("Enter Username: ");
            username = sc.nextLine();

            Registration1 temp = new Registration1(username, "TempPass1!", "+27000000000", "temp", "temp");
            if (temp.checkUserName()) {
                System.out.println("Username successfully captured.");
                break;
            } else {
                System.out.println("Username is not correctly formatted; please ensure that your " +
                    "username contains an underscore and is no more than five characters in length.");
            }
        }

        // ── Password ──────────────────────────────────────────────────────────
        String password;
        while (true) {
            System.out.print("Enter Password: ");
            password = sc.nextLine();

            Registration1 temp = new Registration1(username, password, "+27000000000", "temp", "temp");
            if (temp.checkPasswordComplexity()) {
                System.out.println("Password successfully captured.");
                break;
            } else {
                System.out.println("Password is not correctly formatted; please ensure that the " +
                    "password contains at least eight characters, a capital letter, a number, and a special character.");
            }
        }

        // ── Cell number ───────────────────────────────────────────────────────
        String cell;
        while (true) {
            System.out.print("Enter SA Cell Phone number (+27): ");
            cell = sc.nextLine();

            Registration1 temp = new Registration1(username, password, cell, "temp", "temp");
            if (temp.checkCellPhoneNumber()) {
                System.out.println("Cell phone number successfully added.");
                break;
            } else {
                System.out.println("Cell number is incorrectly formatted or does not contain an " +
                    "international code; please correct the number and try again.");
            }
        }

        // ── First and last name ───────────────────────────────────────────────
        System.out.print("Enter First Name: ");
        String fname = sc.nextLine();

        System.out.print("Enter Last Name: ");
        String lname = sc.nextLine();

        // ── Complete registration ─────────────────────────────────────────────
        Registration1 registration = new Registration1(username, password, cell, fname, lname);
        System.out.println(registration.registerUser());

        // ── Login ─────────────────────────────────────────────────────────────
        System.out.print("Enter Username to login: ");
        String loginUsername = sc.nextLine();

        System.out.print("Enter Password to login: ");
        String loginPassword = sc.nextLine();

        Login1 login = new Login1(loginUsername, loginPassword, registration);
        System.out.println(login.returnLoginStatus());

        sc.close();
    }
}
