//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    (descriptive title of the program making use of this file)
// Course:   CS 300 Fall 2022
//
// Author:   HUAIYUAN JING
// Email:    hjing7@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         None
// Online Sources:  None
//
///////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This class represents a single intersection point where two streets laid out on a grid
 * plan cross at specified x and y coordinate positions.
 */
public class Intersection {
    private final int x;  // X-axis coordinate of this intersection
    private final int y;  // Y-axis coordinate of this intersection

    /**
     * Initializes this intersection with the given coordinate.
     * @param x Horizontal position of this Intersection
     * @param y Vertical position of this Intersection
     */
    public Intersection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the horizontal position of this Intersection
     * @return the horizontal position of this Intersection
     */
    public int getX() {return x;}

    /**
     * Returns the vertical position of this Intersection
     * @return the vertical position of this Intersection
     */
    public int getY() {return y;}

    /**
     * Returns a coordinate-pair representation of this Intersection in the form "(x,y)"
     * @return a coordinate-pair representation of this Intersection
     * @see toString in class Object
     */
    @Override
    public String toString() {
        return "(" + this.getX() + "," + this.getY() + ")";
    }

    /**
     * Returns true if the given Object is identical to this Intersection
     * @param o object to compare for equality
     * @return true if the given Object is an Intersection object which has
     *         the same x and y coordinates as this Intersection
     * @see equals in class Object
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Intersection)) {
            return false;
        }
        Intersection temp = (Intersection) o;
        return temp.getX() == this.getX() && temp.getY() == this.getY();
    }

    /**
     * Creates a new Intersection instance which is one step directly above this Intersection.
     * Should not modify the original Intersection object.
     * @return a new Intersection instance which is one step directly above this Intersection
     */
    public Intersection goNorth() {
        return new Intersection(this.getX(), this.getY() + 1);
    }

    /**
     * Creates a new Intersection instance which is one step directly below this Intersection.
     * Should not modify the original Intersection object.
     * @return a new Intersection instance which is one step directly below this Intersection
     */
    public Intersection goSouth() {
        return new Intersection(this.getX(), this.getY() - 1);
    }

    /**
     * Creates a new Intersection instance which is one step directly to the right of this Intersection object.
     * Should not modify the original Intersection object.
     * @return a new Intersection instance which is one step directly to the right of this Intersection
     */
    public Intersection goEast() {
        return new Intersection(this.getX() + 1, this.getY());
    }

    /**
     * Creates a new Intersection instance which is one step directly to the left of this Intersection.
     * Should not modify the original Intersection object.
     * @return a new Intersection instance which is one step directly to the left of this Intersection
     */
    public Intersection goWest() {
        return new Intersection(this.getX() - 1, this.getY());
    }
}
