package main;

import util.Gradebook;
import util.Grade;
import util.Student;

import java.util.Scanner;

public class Main {

    // Prints a list of available commands for the user to interact with the gradebook
    private static void showCommandMenu() {
        System.out.println("""
            Commands you can use:
            min score - shows minimum score
            min letter - shows minimum letter grade
            max score - shows maximum score
            max letter - shows maximum letter grade
            letter XXXXXXX - shows letter grade for a student (use PID)
            name XXXXXXX - shows name of a student (use PID)
            change XXXXXXX YY - change a student's grade (use PID and new grade)
            average score - shows average score in the gradebook
            average letter - shows average letter grade in the gradebook
            median score - shows median score in the gradebook
            median letter - shows median letter grade in the gradebook
            tab scores - lists all students with their scores
            tab letters - lists all students with their letter grades
            menu - shows this list of commands
            quit - terminates program
            """);
    }

    // Checks if the given name starts with an uppercase letter and only contains letters, spaces, and dots
    private static boolean checkNameValid(String name) {
        // Return false if name doesn't start with an uppercase letter
        if (!Character.isUpperCase(name.charAt(0))) return false;

        // Check each character in the name to make sure it's either a letter, dot, or space
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (Character.isWhitespace(c) || (!Character.isLetter(c) && c != '.')) {
                return false;
            }
        }
        // If we get here, the name is valid
        return true;
    }

    // Checks if the PID is valid (should have 7 digits and not start with zero)
    private static boolean checkPidValid(int pid) {
        // Convert PID to string and check length and first character
        String pidString = Integer.toString(pid);
        return pidString.length() == 7 && pidString.charAt(0) != '0';
    }

    // Checks if the grade is within a valid range (0-100)
    private static boolean checkGradeValid(int grade) {
        return grade >= 0 && grade <= 100;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gradebook gradebook = new Gradebook(); // Create a new gradebook to store student info
        String studentLine;

        System.out.println("Welcome to my gradebook!");
        System.out.println("Please enter the information for student using the following format:“firstName lastName PID grade”.");
        System.out.println("Press enter after each student's information is filled.");
        System.out.println("Type 'DONE' when you have finished entering the students.");

        // Loop to enter student details
        while (true) {
            studentLine = scanner.nextLine();
            // Break the loop if the user types 'DONE'
            if (studentLine.equalsIgnoreCase("DONE")) {
                break;
            }
            // Split input line into parts (first name, last name, PID, grade)
            String[] studentFields = studentLine.split("\\s+");
            // Check that we have exactly 4 parts (valid input)
            if (studentFields.length == 4) {
                // Extract first name, last name, PID, and grade from input
                String firstName = studentFields[0];
                String lastName = studentFields[1];
                int pid = Integer.parseInt(studentFields[2]);
                int gradeScore = Integer.parseInt(studentFields[3]);

                // Validate each part of the input
                if (checkNameValid(firstName) && checkNameValid(lastName) && checkPidValid(pid) && checkGradeValid(gradeScore)) {
                    // Create a new grade and student object and add them to the gradebook
                    Grade gradeObj = new Grade(gradeScore);
                    Student student = new Student(firstName, lastName, pid, gradeObj);
                    gradebook.addStudent(student);
                } else {
                    System.out.println("Invalid input, please try again.");
                }
            } else {
                System.out.println("Input format incorrect, try again.");
            }
        }

        // Display the command menu
        showCommandMenu();

        // Main loop to handle user commands
        while (true) {
            System.out.print("Enter a command: ");
            String userCommand = scanner.nextLine().trim();

            // Break the loop if the user types 'quit'
            if (userCommand.equalsIgnoreCase("quit")) {
                System.out.println("Goodbye!");
                break;
            }

            // Split the command into parts (e.g., 'min score' -> ['min', 'score'])
            String[] commandFields = userCommand.split("\\s+");

            // If the command is empty, ask the user to try again
            if (commandFields.length == 0) {
                System.out.println("Unknown command. Try again.");
                continue;
            }

            // Handle different commands using a switch statement
            switch (commandFields[0]) {
                case "min":
                    handleMinCommand(commandFields, gradebook);
                    break;
                case "max":
                    handleMaxCommand(commandFields, gradebook);
                    break;
                case "letter":
                    if (commandFields.length == 2) {
                        int pid = Integer.parseInt(commandFields[1]);
                        System.out.println(gradebook.getLetterGradeByPid(pid));
                    } else {
                        System.out.println("Invalid input. Try again.");
                    }
                    break;
                case "name":
                    if (commandFields.length == 2) {
                        int pid = Integer.parseInt(commandFields[1]);
                        System.out.println(gradebook.getNameByPid(pid));
                    } else {
                        System.out.println("Invalid input. Try again.");
                    }
                    break;
                case "change":
                    if (commandFields.length == 3) {
                        int pid = Integer.parseInt(commandFields[1]);
                        int grade = Integer.parseInt(commandFields[2]);
                        System.out.println(gradebook.changeStudentGrade(pid, grade));
                    } else {
                        System.out.println("Invalid input. Try again.");
                    }
                    break;
                case "average":
                    handleAverageCommand(commandFields, gradebook);
                    break;
                case "median":
                    handleMedianCommand(commandFields, gradebook);
                    break;
                case "tab":
                    handleTabCommand(commandFields, gradebook);
                    break;
                case "menu":
                    showCommandMenu();
                    break;
                default:
                    System.out.println("Unknown command. Try again.");
            }
        }

        scanner.close();
    }

    // Handles the "min" commands such as "min score" and "min letter"
    private static void handleMinCommand(String[] commandFields, Gradebook gradebook) {
        if (commandFields.length == 2) {
            if ("score".equals(commandFields[1])) {
                // Show the minimum score
                System.out.println("The minimum score is: " + gradebook.findMinScore());
            } else if ("letter".equals(commandFields[1])) {
                // Show the minimum letter grade
                System.out.println("The minimum letter grade is: " + gradebook.findMinLetter());
            } else {
                System.out.println("Invalid command. Try again.");
            }
        } else {
            System.out.println("Invalid command. Try again.");
        }
    }

    // Handles the "max" commands such as "max score" and "max letter"
    private static void handleMaxCommand(String[] commandFields, Gradebook gradebook) {
        if (commandFields.length == 2) {
            if ("score".equals(commandFields[1])) {
                // Show the maximum score
                System.out.println("The maximum score is: " + gradebook.findMaxScore());
            } else if ("letter".equals(commandFields[1])) {
                // Show the maximum letter grade
                System.out.println("The maximum letter grade is: " + gradebook.findMaxLetter());
            } else {
                System.out.println("Invalid command. Try again.");
            }
        } else {
            System.out.println("Invalid command. Try again.");
        }
    }

    // Handles the "average" commands such as "average score" and "average letter"
    private static void handleAverageCommand(String[] commandFields, Gradebook gradebook) {
        if (commandFields.length == 2) {
            if ("score".equals(commandFields[1])) {
                // Show the average score in the gradebook
                System.out.printf("The average score is: %.2f\n", gradebook.computeAverage());
            } else if ("letter".equals(commandFields[1])) {
                // Show the average letter grade in the gradebook
                System.out.println("The average letter grade is: " + gradebook.computeAverageLetter());
            } else {
                System.out.println("Invalid command. Try again.");
            }
        } else {
            System.out.println("Invalid command. Try again.");
        }
    }

    // Handles the "median" commands such as "median score" and "median letter"
    private static void handleMedianCommand(String[] commandFields, Gradebook gradebook) {
        if (commandFields.length == 2) {
            if ("score".equals(commandFields[1])) {
                // Show the median score in the gradebook
                System.out.printf("The median score is: %.2f\n", gradebook.findMedianScore());
            } else if ("letter".equals(commandFields[1])) {
                // Show the median letter grade in the gradebook
                System.out.println("The median letter grade is: " + gradebook.findMedianLetter());
            } else {
                System.out.println("Invalid command. Try again.");
            }
        } else {
            System.out.println("Invalid command. Try again.");
        }
    }

    // Handles the "tab" commands such as "tab scores" and "tab letters"
    private static void handleTabCommand(String[] commandFields, Gradebook gradebook) {
        if (commandFields.length == 2) {
            if ("scores".equals(commandFields[1])) {
                // Display a list of all students with their scores
                gradebook.displayAllStudents();
            } else if ("letters".equals(commandFields[1])) {
                // Display a list of all students with their letter grades
                gradebook.displayAllStudentsLetter();
            } else {
                System.out.println("Invalid command. Try again.");
            }
        } else {
            System.out.println("Invalid command. Try again.");
        }
    }
}


