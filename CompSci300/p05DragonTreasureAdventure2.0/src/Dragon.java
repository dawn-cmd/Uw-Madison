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
 * class for dragon inherit character class implement movable
 */
public class Dragon extends Character implements Moveable{
    private static final String DRAGON_ENCOUNTER = "Oh no! You ran into the fire breathing dragon!\n";
    private static final String DRAGON_WARNING = "You hear a fire breathing nearby!\n";
    private Random randGen;

    /**
     * Constructor for a Dragon object. Initializes all instance fields. The label should be "DRAGON" by default.
     * @param currentRoom the room that the Dragon starts in
     * @throws IllegalArgumentException with a descriptive message if currentRoom is not a TreasureRoom
     */
    public Dragon(Room currentRoom) throws IllegalArgumentException {
        super(currentRoom, "DRAGON");
        if (!(currentRoom instanceof TreasureRoom)) {
            throw new IllegalArgumentException("currentRoom is not a TreasureRoom");
        }
        randGen = new Random();
    }

    /**
     * Checks if the dragon can move to the given destination. A valid move is the destination not a PortalRoom.
     * @param destination the room to check if the dragon can move towards
     * @return true if they can, false otherwise
     */
    @Override
    public boolean canMoveTo(Room destination) {
        return !(destination instanceof PortalRoom) && this.getAdjacentRooms().contains(destination);
    }

    /**
     * Moves the Dragon to the destination room.
     * @param destination the Room to change it to
     * @return true if the change was successful, false otherwise
     */
    @Override
    public boolean changeRoom(Room destination) {
        if (!this.canMoveTo(destination)) {return false;}
        this.setCurrentRoom(destination);
        return true;
    }

    /**
     * Picks randomly ONCE an adjacent room to move into.
     * @return the room that this Dragon should try to move into
     */
    public Room pickRoom() {
        ArrayList<Room> adjs = this.getAdjacentRooms();
        return adjs.get(randGen.nextInt(adjs.size()));
    }

    /**
     * Getter for DRAGON_WARNING.
     * @return the string for warning about a dragon being nearby.
     */
    public static String getDragonWarning() {return Dragon.DRAGON_WARNING;}

    /**
     * Getter for DRAGON_ENCOUNTER.
     * @return the string for letting the player know they ran into the dragon.
     */
    public static String getDragonEncounter() {return Dragon.DRAGON_ENCOUNTER;}
}
