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
 * class for character
 */
public class Character {
    private Room currentRoom;
    private String label;

    /**
     * Constructor for a Character object. Initializes all instance fields.
     * @param currentRoom the room that the Character is located in
     * @param label a descriptive label of this Character
     * @throws IllegalArgumentException with a descriptive message if currentRoom is null.
     */
    public Character(Room currentRoom, String label) throws IllegalArgumentException {
        if (currentRoom == null) {
            throw new IllegalArgumentException("currentRoom is null");
        }
        this.currentRoom = currentRoom;
        this.label = label;
    }

    /**
     * Getter for the current room of this Character.
     * @return the room where the character is
     */
    public Room getCurrentRoom() {return this.currentRoom;}

    /**
     * Getter for the label of this Character.
     * @return this Character's descriptive label
     */
    public String getLabel() {return this.label;}

    /**
     * Gets the list of rooms adjacent to this Character.
     * @return an ArrayList of rooms adjacent to this character
     */
    public ArrayList<Room> getAdjacentRooms() {return this.currentRoom.getAdjacentRooms();}

    /**
     * Sets the current room to the one given.
     * @param newRoom the room that should become the current room
     */
    public void setCurrentRoom(Room newRoom) {this.currentRoom = newRoom;}
}
