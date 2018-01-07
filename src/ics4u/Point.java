package ics4u;

/*
ics4u.Point implements the concept of a point on a graph.
*/
public class Point {
    // Data fields for a point
    private double x;
    private double y;

    /*
    Constructor for more flexibility.
    */
    public Point(double A, double B) {
        x = A;
        y = B;
    }

    /*
    Returns the x value.
     */
    public double getX() {
        return x;
    }

    /*
    Returns the y value.
     */
    public double getY() {
        return y;
    }

    /*
    Converts the values to a String value.
     */
    public String toString() {
        return "x = " + String.format("%.10f", x) + " y = " + String.format("%.10f", y);
    }
}