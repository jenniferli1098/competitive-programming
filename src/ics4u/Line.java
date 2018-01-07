package ics4u;/*
Class used to represent the line.
 */

public class Line {
    // Private instance fields to keep track of the coefficients of x and y, as well as the constant variable
    // in the equation of the line
    private int A; // corresponds to coefficient on x
    private int B; // corresponds to coefficient on y
    private int C; // corresponds to the constant value

    /*
    Default constructor for the class that takes in the values of A, B and C.
     */
    public Line(int a, int b, int c) {
        A = a;
        B = b;
        C = c;
    }

    /*
    Overloaded constructor for the default constructor. Default line is y = 0.
     */
    public Line() {
        A = 0;
        B = 1;
        C = 0;
    }

    /*
    Returns X-intercept.
     */
    public double getXIntercept() {
        return (1.0 * -C) / A;
    }

    /*
    Returns the intercept.
     */
    public double getYIntercept() {
        return (1.0 * -C) / B;
    }

    /*
    Returns the slope.
     */
    public double getSlope() {
        return (1.0 * -A) / B;
    }

    /*
    Returns whether it's a vertical line.
     */
    public boolean isVertical() {
        return A != 0 && B == 0;
    }

    /*
    Returns whether it's a horizontal line.
     */
    public boolean isHorizontal() {
        return A == 0 && B != 0;
    }

    /*
    Checks the point of intersection between two lines.s
     */
    public Point intersect(Line secondLine) {
        // Checks if both lines are vertical or horizontal lines
        if (((isVertical() && secondLine.isVertical()) || (isHorizontal() && secondLine.isHorizontal()))) {
            return null;
        }

        // Checks the point of intersection of vertical and horizontal lines
        if (isVertical() && secondLine.isHorizontal()) {
            return new Point(getXIntercept(), secondLine.getYIntercept());
        }

        if (secondLine.isVertical() && isHorizontal()) {
            return new Point(secondLine.getXIntercept(), getYIntercept());
        }

        // Checks if lines have the same slope, and account for double precision loss
        if (Math.abs(getSlope() - secondLine.getSlope()) < 1.0e-9) {
            return null;
        }

        // Handles horizontal lines
        if (isVertical()) {
            double x = getXIntercept();
            return new Point(x, secondLine.fAt(x));
        }

        // And the other way around
        if (secondLine.isVertical()) {
            double x = secondLine.getXIntercept();
            return new Point(x, fAt(x));
        }

        // Checks the point of intersection through a formula
        double poiX = -(getYIntercept() - secondLine.getYIntercept()) / (getSlope() - secondLine.getSlope());
        return new Point(poiX, fAt(poiX));
    }

    /*
    Returns y value given the x value.
     */
    public double fAt(double x) {
        return (-A * x - C) / B;
    }

    /*
    Reads a line from standard input.
     */
    public void readLine(FastScanner sc) {
        // Variables used to read and parse the line
        String validCharacters = "0123456789+-=xy";
        boolean valid = false;

        // Accumulator variable used to parse the input
        String equation;

        // Variables for coefficients corresponding to the equation
        int xCoefficient;
        int yCoefficient;
        int constantValue;

        // marks the code to continue here if the line cannot be parsed
        while (!valid) {
            valid = true; // assume it's valid

            System.out.print("Enter the equation of a line: ");
            equation = sc.nextLine().trim();

            // Remove spaces in the String
            equation = equation.replaceAll("[ .]", "");

            // Split the line to two equations
            String[] bothSides = equation.split("=");

            if (bothSides.length != 2) {
                System.out.println("There was an error in the equation. Please set the equation equal to a value.\n");
                valid = false;
            } else {
                // Verify that the equation doesn't have invalid variables
                for (int i = 0; i < equation.length(); i++) {
                    if (validCharacters.indexOf(equation.charAt(i)) == -1) {
                        System.out.println("Please enter valid numbers and variable names!\n");
                        valid = false;
                        break; // break out of the for loop since something is wrong already
                    }
                }

                // Ensure no invalid placements were put into the line
                if ((equation.contains("++") || equation.contains("--")) && valid) {
                    System.out.println("Please enter valid syntax!\n");
                    valid = false;
                }

                if (valid) { // ensure there were no errors from beforehand
                    // Declare arrays
                    int[] leftSide;
                    int[] rightSide;

                    try {
                        // Get each of the individual letters on both sides of the equal sign
                        leftSide = parse(bothSides[0]);
                        rightSide = parse(bothSides[1]);
                    } catch (Exception e) {
                        System.out.println("Please enter a valid line!\n");
                        valid = false; // set valid to false to re-run the loop
                        continue;
                    }

                    // Calculate the x, y, and constant terms
                    xCoefficient = leftSide[0] - rightSide[0];
                    yCoefficient = leftSide[1] - rightSide[1];
                    constantValue = leftSide[2] - rightSide[2];

                    // Sets the value of the current line accordingly
                    A = xCoefficient;
                    B = yCoefficient;
                    C = constantValue;

                    // Sets variable true in order to exit out of the sentinel-controlled loop
                    if (A != 0 || B != 0) { // ensure there is at least an x or y
                        valid = true;
                    } else { // print out an error message
                        System.out.println("Please enter a valid line!\n");
                        valid = false; // set valid to false to re-run the loop
                    }
                }
            }
        }
    }

    /*
    Parses the inputted String from the readLine(ics4u.FastScanner sc) method. Returns an array of the coefficients.
     */
    private static int[] parse(String input) {
        // Declare accumulators
        int xCount = 0;
        int yCount = 0;
        int constant = 0;

        // Make the string parse-able
        input = input.replaceAll("(?<!\\d)([a-z])", "1$1");    // Replaces any lower letters with 1 concatenated with the same letter
        if (!input.startsWith("-")) {
            input = "+" + input;  // if the first character is not negative add a + to it
        }

        // Make it possible to split the string
        input = input.replaceAll("[+.]", "/+").replaceAll("[-.]", "/-") + "/";

        String[] terms = input.split("/");

        for (String current : terms) {
            if (current.length() <= 1) {
                // Case can be skipped as this may represent a space or line break
            } else {
                // Remove + sign if there is one
                int locationOfPositive = current.indexOf("+");

                // Removes +
                if (locationOfPositive > -1) {
                    current = current.substring(0, locationOfPositive) + current.substring(locationOfPositive + 1, current.length());
                }

                // Parses and determines which variable to add on to
                if (current.contains("x")) {
                    xCount += Integer.parseInt(current.substring(0, current.length() - 1));
                } else if (current.contains("y")) {
                    yCount += Integer.parseInt(current.substring(0, current.length() - 1));
                } else {
                    constant += Integer.parseInt(current.substring(0, current.length()));
                }
            }
        }

        // Returns an object with the count of each variable (in order to save time by not calling it again and again)
        return new int[]{xCount, yCount, constant};
    }

    /*
    Converts the equation of a line to a String.
     */
    public String toString() {
        // Add the text as it goes
        String accumulator = "";

        // Parses the a value and places - if needed
        if (Math.abs(A) == 1) {
            accumulator += (A < 0 ? "-" : "") + "x";
        } else if (A != 0) {
            accumulator += A + "x";
        }

        // Parses the b value and places + or - if needed
        if (Math.abs(B) == 1) {
            accumulator += (B < 0 ? "-" : (A == 0 ? "" : "+")) + "y";
        } else if (B != 0) {
            accumulator += (B < 0 ? "" : A != 0 ? "+" : "") + B + "y";
        }

        // Parses the c value and places + or - if needed
        if (C != 0) {
            accumulator += (C < 0 ? "" : "+") + C;
        }

        // Since the equation is equal to zero, append = 0, and return the String
        return accumulator + "=0";
    }
}