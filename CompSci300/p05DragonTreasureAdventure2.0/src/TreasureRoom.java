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
 * TreasureRoom Class inherit Room class
 */
public class TreasureRoom extends Room{
    private static final String TREASURE_WARNING = "You sense that there is treasure nearby.\n";
    private static PImage treasureBackground;

    /**
     * Constructor for a TresureRoom object and have a description of "In the back of this room, you spot a treasure chest. It is locked...". Intializes all instance data fields.
     * @param ID the ID to give to this object
     */
    public TreasureRoom(int ID) {
        super(ID, "In the back of this room, you spot a treasure chest.", TreasureRoom.treasureBackground);
    }

    /**
     * Getter for TREASURE_WARNING.
     * @return the string for warning about treasure being nearby.
     */
    public static String getTreasureWarning() {return TreasureRoom.TREASURE_WARNING;}

    /**
     * Sets the background image for the TreasureRoom class.
     * @param treasureBackground the image to be the background
     */
    public static void setTreasureBackground(PImage treasureBackground) {
        TreasureRoom.treasureBackground = treasureBackground;
    }

    /**
     * Determines whether or not the player can open the treasure chest in the room.
     * @param p the Player to check if they can open the chest
     * @return true if the player has the key and is in this TreasureRoom, false otherwise
     */
    public boolean playerCanGrabTreasure(Player p) {return p.hasKey();}
}
