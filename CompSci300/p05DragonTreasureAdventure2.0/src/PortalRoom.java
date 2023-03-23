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
 * class for portalRoom inherit Room class
 */
public class PortalRoom extends Room{
    private static final String PORTAL_WARNING = "You feel a distortion in space nearby.\n";
    private static PImage portalImage;
    private Random randGen;
    private static final String TELEPORT_MESSAGE = "The space distortion teleported you to another room!\n";

    /**
     * Constructor for a PortalRoom object. Initializes all instance data fields.
     * @param ID the ID that this PortalRoom should have
     * @param description the verbal description this PortalRoom should have
     * @param image the image that should be used as a background when drawing this PortalRoom.
     */
    public PortalRoom(int ID, String description, PImage image) {
        super(ID, description, image);
    }

    /**
     * Getter for PORTAL_WARNING.
     * @return the string for warning about a portal being nearby.
     */
    public static String getPortalWarning() {return PortalRoom.PORTAL_WARNING;}

    /**
     * Getter for TELEPORT_MESSAGE.
     * @return the string for letting the player know they were teleported.
     */
    public static String getTeleportMessage() {return PortalRoom.TELEPORT_MESSAGE;}

    /**
     * Picks an adjacent room at random for the player to teleport into.
     * @return The room that player should immediately be moved to
     */
    public Room getTeleportLocation() {
        ArrayList<Room> adj = this.getAdjacentRooms();
        return adj.get(randGen.nextInt(adj.size()));
    }

    /**
     * Draws this PortalRoom to the window by drawing the background image, a rectangle, some text, and the portal image.
     * @override draw in class Room
     */
    @Override
    public void draw() {
        super.draw();
        Room.processing.image(this.portalImage, 325, 225);
    }

    /**
     * Sets the portal image for the PortalRoom class.
     * @param portalImage the image to represent the portal
     */
    public static void setPortalImage(PImage portalImage) {
        PortalRoom.portalImage = portalImage;
    }
}
