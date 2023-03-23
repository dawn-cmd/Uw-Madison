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
 * This class represents a valid path through a grid of city intersections surrounded by streets.
 * That is, one which only moves either one step directly east, or one step directly north at each step,
 * meaning that only northeast paths from one intersection point to another are allowed.
 * A list of intersection elements creates the path.
 */
public class Path {
    private ArrayList<Intersection> intersections;

    /**
     * Initializes this Path to start as empty.
     */
    public Path() {
        this.intersections = new ArrayList<>();
    }

    /**
     * Returns the number of Intersections in this Path
     * @return the number of Intersections in this Path
     */
    public int length() {
        return this.intersections.size();
    }

    /**
     * Returns the first Intersection in this Path, if it is not empty.
     * Otherwise, throws a NoSuchElementException.
     * @return the first Intersection in this Path, if it is not empty
     * @throws NoSuchElementException if this Path is empty
     */
    public Intersection getHead() throws NoSuchElementException {
        if (this.intersections.isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.intersections.get(0);
    }

    /**
     * Returns the last Intersection in this Path, if it is not empty.
     * Otherwise, throws a NoSuchElementException.
     * @return the last Intersection in this Path, if it is not empty
     * @throws NoSuchElementException if this Path is empty
     */
    public Intersection getTail() throws NoSuchElementException {
        if (this.intersections.isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.intersections.get(this.intersections.size() - 1);
    }

    /**
     * Adds the given Intersection to the end of this Path if it is a valid addition.
     * A Intersection is a valid addition if the current Path is empty,
     * or the Intersection to add is one step directly east,
     * or one step directly north of the current tail Intersection in this Path.
     * Should throw an IllegalArgumentException if the given Intersection is not a valid addition.
     * @param toAdd Intersection to add to the end of this Path
     * @throws IllegalArgumentException if the Intersection to add is not valid
     */
    public void addTail(Intersection toAdd) throws IllegalArgumentException {
        if (this.intersections.isEmpty()) {
            this.intersections.add(toAdd);
            return;
        }
        Intersection temp = this.getTail();
        if (!(toAdd.equals(temp.goNorth())) && !(toAdd.equals(temp.goEast()))) {
            throw new IllegalArgumentException();
        }
        this.intersections.add(toAdd);
    }

    /**
     * Adds the given Intersection to the front of this Path if it is a valid addition.
     * A Intersection is a valid addition if the current Path is empty,
     * or the Intersection to add is one step directly west,
     * or one step directly south of the current head Intersection in this Path.
     * Should throw an IllegalArgumentException if the given Intersection is not a valid addition.
     * @param toAdd Intersection to add to the beginning of this Path
     * @throws IllegalArgumentException if the Intersection to add is not valid
     */
    public void addHead(Intersection toAdd) throws IllegalArgumentException {
        if (this.intersections.isEmpty()) {
            this.intersections.add(0, toAdd);
            return;
        }
        Intersection temp = this.getHead();
        if (!(toAdd.equals(temp.goWest())) && !(toAdd.equals(temp.goSouth()))) {
            throw new IllegalArgumentException();
        }
        this.intersections.add(0, toAdd);
    }

    /**
     * Returns a String representing the coordinates taken in this Path.
     * An empty Path should return the String "Empty",
     * while a non-empty Path should return the coordinates of the Intersections it visits separated by a "->"
     * For example:
     * (0,0)->(1,0)->(1,1)->(1,2)
     * @return a String representing the coordinates followed by this Path
     * @see toString in class Object
     */
    @Override
    public String toString() {
        if (this.intersections.isEmpty()) {
            return "Empty";
        }
        String ans = "";
        boolean fst = true;
        for (Intersection i: this.intersections) {
            if (!fst) {
                ans += "->";
            }
            fst = false;
            ans += i.toString();
        }
        return ans;
    }
}
