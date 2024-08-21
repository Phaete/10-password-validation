package com.phaete;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter password too validate or type \"random\" to generate one. ");
        String password = scanner.nextLine();

        if (password.equals("random")) {
            System.out.println(generateSecurePassword());
        } else {
            if (checkLength(password) && containsDigits(password) && containsLowerCase(password) && containsUpperCase(password) && !isCommonPassword(password)) {
                System.out.println("Password is good to go.");
            } else {
                System.out.println("Password is bad, maybe choose another one.");
            }
        }
    }

    public static boolean checkLength(String password) {
        return password.length() >= 8;
    }

    public static boolean containsDigits(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsLowerCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsUpperCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCommonPassword(String password) {
        String[] commonPasswords = {
                "Password!",
                "PassWord!",
                "Password1!",
                "PassWord1!",
                "Password1!2",
                "PassWord1!2",
                "Password1!23",
                "PassWord1!23",
                "A1!b2C3§d4E5f6G7h8I9",
                "a1!B2c3§D4e5F6g7H8",
                "1!Q2w3§E4r",
                "Sunsh1ne.",
                "1l0veYou!123",
                "B4seBall!",
                "whatever_w/e",
                "trustNo_1",
                "Superman_123",
                "1Qaz2w$x",
                "StarWars.1"
        };
        for (String commonPassword : commonPasswords) {
            if (password.equals(commonPassword)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsSpecialCharacters(String password) {
        for (char c : password.toCharArray()) {
            // Character is special if not a letter, digit, or whitespace
            if (!Character.isLetter(c) && !Character.isDigit(c) && !Character.isWhitespace(c)) {
                return true;
            }
        }
        return false;
    }

    public static String generateSecurePassword() {
        // Generate random number for length of the password, min 8 characters, max 24
        int length = (int) (Math.random() * 16) + 8;
        ArrayList<Object> password = new ArrayList<>();
        // Add one lower case letter, one upper case letter, one digit, and one special character
        password.add((char) ((int) (Math.random() * 26) + 97));
        password.add((char) ((int) (Math.random() * 26) + 65));
        password.add((char) ((int) (Math.random() * 10) + 48));
        password.add((char) ((int) (Math.random() * 5) + 33));
        // Add the rest of the characters in a loop
        for (int i = 4; i < length; i++) {
            // Generate random number for type of character
            int type = (int) (Math.random() * 4);
            // type = 0 -> lower case letter, type = 1 -> upper case letter, type = 2 -> digit, type = 3 -> special character
            if (type == 0) {
                // Generate random lower case letter using ASCII table
                password.add((char) ((int) (Math.random() * 26) + 97));
            } else if (type == 1) {
                // Generate random upper case letter using ASCII table
                password.add((char) ((int) (Math.random() * 26) + 65));
            } else if (type == 2) {
                // Generate random digit using ASCII table
                password.add((char) ((int) (Math.random() * 10) + 48));
            } else {
                // Generate random special character
                password.add((char) ((int) (Math.random() * 5) + 33));
            }
        }
        // Shuffle the collection for random placement of all the characters
        Collections.shuffle(password);

        // Convert the collection to a string and return it
        return String.valueOf(password);
    }
}