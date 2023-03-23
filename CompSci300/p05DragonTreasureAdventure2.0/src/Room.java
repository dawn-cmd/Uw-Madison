//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    (descriptive title of the program making use of this file)
// Course:   CS 300 Fall 2022
//
// Author:   HuaiYuan Jing
// Email:    hjing7@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:            None
// Partner Email:           None
// Partner Lecturer's Name: None
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

import processing.core.PApplet;
import processing.core.PImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 * This is a class of room
 */
public class Room {
    private String description; //verbal description of the room
    private ArrayList<Room> adjRooms; //list of all rooms directly connect
    private final int ID; // a "unique" identifier for each room
    protected static PApplet processing; //PApplet object which the rooms will use to
    //draw stuff to the GUI
    private PImage image; //stores the image that corresponds to the background of a room

    /**
     * Constructor for a Room object. Initializes all instance data fields.
     * @param ID the ID that this Room should have
     * @param description the verbal description this Room should have
     * @param image the image that should be used as a background when drawing this Room.
     */
    public Room(int ID, String description, PImage image) {
        this.ID = ID;
        this.description = description;
        this.image = image;
        this.adjRooms = new ArrayList<>();
    }

    /**
     * Getter for ID.
     * @return the ID of this Room
     */
    public int getID() {return this.ID;}

    /**
     * Getter for description.
     * @return the verbal description of this Room
     */
    public String getDescription() {return this.description;}

    /**
     * Getter for the list of adjacentRooms.
     * @return the list of adjacent rooms
     */
    public ArrayList<Room> getAdjacentRooms() {return this.adjRooms;}

    /**
     * Sets the processing for the class.
     * @param processing the PApplet that this room will use to draw to the window
     */
    public static void setProcessing(PApplet processing) {Room.processing = processing;}

    /**
     * Adds the given room to the list of rooms adjacent to this room.
     * @param toAdd the room to be added
     */
    public void addToAdjacentRooms(Room toAdd) {this.adjRooms.add(toAdd);}

    /**
     * Checks whether or not the given room is adjacent to this room.
     * @param r the room to check for adjacency
     * @return true if it is adjacent, false otherwise
     */
    public boolean isAdjacent(Room r) {return this.adjRooms.contains(r);}

    /**
     * Overrides Object.equals(). Determines if two objects are equal.
     * @override equals in class Object
     * @param other the object to check against the Room
     * @return true if other is of type Room and has the same ID, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {return true;}
        if (!(other instanceof Room)) {return false;}
        Room temp = (Room) other;
        return temp.getID() == this.getID();
    }

    /**
     * Overrides Object.toString(). Returns a string representation of a Room object.
     * @override toString in class Object
     * @return Returns a string in the form of "<ID>: <description>\n Adjacent Rooms: <r1's ID> <r2's ID>" list of adjacent room IDs continues for all rooms adjacent to this Room.
     */
    @Override
    public String toString() {
        String ans = this.getID() + ": " + this.getDescription() + "\n Adjacent Rooms:";
        for (Room r: this.getAdjacentRooms()) {
            ans += " " + r.getID();
        }
        return ans;
    }

    /**
     * Draws this Room to the window by drawing the background image, a rectangle, and some text.
     */
    public void draw() {
        Room.processing.image(this.image, 0, 0);
        Room.processing.fill(-7028);
        Room.processing.rect(0, 500, 800, 600);
        Room.processing.fill(0);
        Room.processing.text(this.toString(), 300, 525);
    }
}
