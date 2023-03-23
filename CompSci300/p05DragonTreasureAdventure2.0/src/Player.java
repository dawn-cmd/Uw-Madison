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
 * class for player inherit character class implement moveable
 */
public class Player extends Character implements Moveable{
    private boolean hasKey;

    /**
     * Constructor for player object. The label should be "PLAYER" and not have a key by default.
     * @param currentRoom the room that the player should start in
     * @throws IllegalArgumentException if the currentRoom is not a StartRoom
     */
    public Player(Room currentRoom) throws IllegalArgumentException {
        super(currentRoom, "PLAYER");
        if (!(currentRoom instanceof StartRoom)) {
            throw new IllegalArgumentException("currentRoom is not a StartRoom");
        }
        this.hasKey = false;
    }

    /**
     * Determines if the player has the key.
     * @return true if the player has the key, false otherwise
     */
    public boolean hasKey() {return this.hasKey;}

    /**
     * Gives player the key.
     */
    public void obtainKey() {this.hasKey = true;}

    /**
     * changeRoom in interface Moveable
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
     * Checks if the player can move to the given destination. A valid move is the destination is a room adjacent to the player.
     * @param destination the room to check if the player can move towards
     * @return true if they can, false otherwise
     */
    @Override
    public boolean canMoveTo(Room destination) {return this.getAdjacentRooms().contains(destination);}

    /**
     * Checks if the player needs to teleport and move them if needed.
     * @return true if a teleport occurred, false otherwise
     */
    public boolean teleport() {
        if (!(this.getCurrentRoom() instanceof PortalRoom)) {return false;}
        return this.changeRoom(((PortalRoom) this.getCurrentRoom()).getTeleportLocation());
    }

    /**
     * Determines whether or not a portal room is nearby. A portal room is considered nearby if it is one of the adjacent rooms.
     * @return true if a portal room is nearby, false otherwise
     */
    public boolean isPortalNearby() {
        for (Room r: this.getAdjacentRooms()) {
            if (r instanceof PortalRoom) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determines whether or not the treasure room is nearby. The treasure room is considered nearby if it is one of the adjacent rooms.
     * @return true if the treasure room is nearby, false otherwise
     */
    public boolean isTreasureNearby() {
        for (Room r: this.getAdjacentRooms()) {
            if (r instanceof TreasureRoom) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determines whether or not the given dragon is nearby. A dragon is considered nearby if it is in one of the adjacent rooms.
     * @param d the dragon to check if nearby
     * @return true if the dragon is nearby, false otherwise
     */
    public boolean isDragonNearby(Dragon d) {return this.getAdjacentRooms().contains(d.getCurrentRoom());}
}
