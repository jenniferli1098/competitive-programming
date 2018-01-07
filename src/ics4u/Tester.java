package ics4u;

import java.util.ArrayList;

public class Tester {

    private static FastScanner sc = new FastScanner();

    private static ArrayList<Line> lines = new ArrayList<>(); // Keeps track of dynamic ics4u.Line objects

    public static void main(String[] args) { // Program header
        System.out.println("ics4u.Line Class by Shehryar Assad.\n");

        char choice;

        // Create a menu using a do while loop that's sentinel controlled toward the exit
        do {
            displayMenu();
            System.out.print("Choice: ");

            // Get the first character from the first string
            choice = sc.nextChar();

            // Execute the program corresponding to the choice
            if (choice == '1') {
                System.out.println();

                // Create a new ics4u.Line object (with default parameters used)
                Line line = new Line();

                // Read the line using the ics4u.Line class
                line.readLine(sc);

                // Add the line to the ArrayList
                lines.add(line);

                // Show user the line
                System.out.println("\nCreated a new line: " + line);

                // Print out information about a line
                printLineInformation(line);

                // Leave a space
                System.out.println();
            } else if (choice == '2') {
                System.out.println();

                if (lines.size() == 0) {
                    System.out.println("There are no lines yet! Press 1 to add one.");
                } else {
                    // List all the lines
                    System.out.println("List of lines: ");
                    displayLinesOnConsole();

                    // Leaave a space
                    System.out.println();

                    // Get a valid line number
                    int lineToRemove = getValidInput("Select a line to remove: ", 1, lines.size());

                    // Remove the line from the ArrayList
                    System.out.println("\nRemoving line " + lineToRemove);
                    lines.remove(lineToRemove - 1);

                    // Display the updated list
                    System.out.println("\nUpdated list: ");
                    displayLinesOnConsole();

                    // Leave space
                    System.out.println();
                }
            } else if (choice == '3') {
                System.out.println();

                // Ensure there are lines
                if (lines.size() == 0) {
                    System.out.println("There are no lines yet! Press 1 to add one.");
                } else {
                    // List all the lines
                    System.out.println("List of lines: ");
                    displayLinesOnConsole();

                    // Leaave a space
                    System.out.println();

                    // Get a valid line number
                    int selectedLine = getValidInput("Select a line: ", 1, lines.size());

                    // Gets the line in question
                    Line line = lines.get(selectedLine - 1);

                    // Leave a space
                    System.out.println();

                    // Deal with the line through the method
                    selectLine(line);
                }
            } else if (choice == '4') {
                // Print out the list of lines
                System.out.println("\nList of lines: ");
                displayLinesOnConsole();

                // Leave a space
                System.out.println();
            } else {
                // Leave a space
                System.out.println();
            }

            // Wait 3 seconds before redisplaying menu
            try {
                System.out.println("Waiting 3 seconds...");
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println();
        } while (choice != 'q'); // If user chooses to quit, show final message and exit program

        System.out.println("Execution finished.");
    }

    private static void displayMenu() {
        // Display the menu for all the problems
        System.out.printf("%-30s                       %s%n", "Command", "Key");
        System.out.printf("%-30s                       %s%n", "Add ics4u.Line", "1");
        System.out.printf("%-30s                       %s%n", "Remove ics4u.Line", "2");
        System.out.printf("%-30s                       %s%n", "Select ics4u.Line", "3");
        System.out.printf("%-30s                       %s%n", "Display Lines on Console", "4");
        System.out.printf("%-30s                       %s%n", "Quit", "q");
    }

    private static void displaySelectMenu() {
        // Display the menu for all the problems
        System.out.printf("%-30s                       %s%n", "Command", "Key");
        System.out.printf("%-30s                       %s%n", "Print Information", "1");
        System.out.printf("%-30s                       %s%n", "Intersect ics4u.Line", "2");
        System.out.printf("%-30s                       %s%n", "Return to menu", "q");
    }

    private static void displayLinesOnConsole() {
        // Prints out the lines on the screen and displays them per Last In Last Displayed manner
        if (lines.size() == 0) {
            System.out.println("No lines!");
        } else {
            for (int i = 0; i < lines.size(); i++) {
                System.out.println("ics4u.Line " + (i + 1) + ": " + lines.get(i));
            }
        }
    }

    private static void printLineInformation(Line line) {
        // Prints out the x-intercepts
        System.out.print("x-intercept: ");

        if (!line.isHorizontal()) { // Ensures the line isn't a horizontal one
            System.out.printf("%.10f%n", line.getXIntercept()); // could be -0.0000000000 due to double precision errors
        } else if (line.isHorizontal() && Math.abs(line.getYIntercept()) < 1.0e-9) {
            System.out.println("infinite");
        } else {
            System.out.println("none");
        }

        // Prints out the y-intercept
        System.out.print("y-intercept: ");

        if (!line.isVertical()) { // Ensures the line isn't a vertical one
            System.out.printf("%.10f%n", line.getYIntercept());
        } else if (line.isVertical() && Math.abs(line.getXIntercept()) < 1.0e-9) {
            System.out.println("infinite");
        } else {
            System.out.println("none");
        }

        // Gets the slope and also prints it out
        System.out.print("slope: ");
        double slope = line.getSlope();

        if (!(Double.isInfinite(slope))) { // Ensures the slope is defined
            System.out.printf("%.10f%n", slope);
        } else {
            System.out.println("undefined");
        }
    }

    private static void selectLine(Line line) {
        char choice;

        do {
            // Prints out the line to inform the user of the line chosen
            System.out.println("Selected line: " + line + "\n");

            // Display the menu
            displaySelectMenu();
            System.out.print("Choice: ");

            // Get the first character from the first string
            choice = sc.nextLine().toLowerCase().charAt(0);

            if (choice == '1') {
                // Leave space
                System.out.println();

                // Print out information regarding the line
                printLineInformation(line);

                // Leave a space
                System.out.println();
            } else if (choice == '2') {
                // No need to check the size of ArrayList<ics4u.Line> lines, as it's guaranteed to be greater than 0

                // List all the lines
                System.out.println("\nList of lines: ");
                displayLinesOnConsole();

                // Leaave a space
                System.out.println();

                // Get a valid line number
                int selectedLineIndex = getValidInput("Select a line to intersect: ", 1, lines.size());

                // Gets the selected line from the tracking ArrayList
                Line selectedLine = lines.get(selectedLineIndex - 1);

                // Print format message
                System.out.println("\nIntersecting: " + line + " with " + selectedLine);

                // Determines and prints out the point of intersection of the two lines in question
                Point poi = line.intersect(selectedLine);

                // Print result
                if (poi == null) {
                    System.out.println("No points of intersections or same line.");
                } else {
                    System.out.println("ics4u.Point of intersection is: " + poi);
                }

                // Leave a space
                System.out.println();
            }

        } while (choice != 'q');

        // Leave a space
        System.out.println();
    }

    private static int getValidInput(String msg, int lowerBound, int upperBound) {
        // Print the initial message
        System.out.print(msg);

        // Get the value from the user
        int current = sc.nextInt();

        // Ensure the value is in the bound
        while (current < lowerBound || current > upperBound) {
            // Indicate an error and reprint the error message
            System.out.print("\nError. " + msg);
            current = sc.nextInt();
        }

        // Return the valid value now
        return current;
    }

}