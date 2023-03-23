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
 * This is a class to process the DragonTreasureGame
 */
public class DragonTreasureGame extends PApplet{
    private ArrayList<Room> roomList;
    private File roomInfo;
    private File mapInfo;
    private ArrayList<Character> characters;
    private boolean isDragonTurn;
    private int gameState;

    /**
     * This method is to set the window size
     */
    @Override
    public void settings() {
        this.size(800, 600);
    }


    /**
     * Overwrite the setup() method
     */
    @Override
    public void setup() {
        this.getSurface().setTitle("Dragon Treasure Adventure"); // sets the title of the window
        this.imageMode(PApplet.CORNER); //Images are drawn using the x,y-coordinate
        //as the top-left corner
        this.rectMode(PApplet.CORNERS); //When drawing rectangles interprets args
        //as top-left corner and bottom-right corner respectively
        this.focused = true; // window will be active upon running program
        this.textAlign(CENTER); // sets the text alignment to center
        this.textSize(20); //sets the font size for the text
        this.roomList = new ArrayList<>();
        this.roomInfo = new File("./roominfo.txt");
        this.mapInfo = new File("./map.txt");
        this.characters = new ArrayList<>();
        this.loadRoomInfo();
        this.loadMap();
        this.loadCharacters();
        this.isDragonTurn = false;
        this.gameState = 0;
        Room.setProcessing(this);
        TreasureRoom.setTreasureBackground(this.loadImage("./images/treasure.jpg"));
        PortalRoom.setPortalImage(this.loadImage("./images/portal.png"));
    }

    /** Loads in room info using the file stored in roomInfo
     *  @author Michelle
     */
    private void loadRoomInfo() {
        System.out.println("Loading rooms...");
        Scanner fileReader = null;
        try {

            //scanner to read from file
            fileReader= new Scanner(roomInfo);

            //read line by line until none left
            while(fileReader.hasNext()) {
                String nextLine = fileReader.nextLine();

                //parse info and create new room
                String[] parts = nextLine.split(" \\| ");
                int ID = Integer.parseInt(parts[1].trim()); //get the room id
                String imageName = null;
                String description = null;
                PImage image = null;
                Room newRoom = null;

                if(parts.length >= 3) {
                    imageName = parts[2].trim();
                    image = this.loadImage("images" + File.separator + imageName);

                }

                if(parts.length == 4) {
                    description = parts[3].trim(); //get the room description
                }

                switch(parts[0].trim()) {
                    case "S":
                        newRoom = new StartRoom(ID, image);
                        break;
                    case "R":
                        newRoom = new Room(ID, description, image);
                        break;
                    case "P":
                        newRoom = new PortalRoom(ID, description, image);
                        break;
                    case "T":
                        newRoom = new TreasureRoom(ID);
                        break;
                    default:
                        break;
                }

                if(newRoom != null) {
                    roomList.add(newRoom);
                }
            }
        }catch(IOException e) { //handle checked exception
            e.printStackTrace();
        }finally {
            if(fileReader != null)
                fileReader.close(); //close scanner regardless of what happened for security reasons :)
        }
    }

    /** Loads in room connections using the file stored in mapInfo
     *  @author Michelle
     */
    private void loadMap() {
        System.out.println("Loading map...");
        Scanner fileReader = null;
        try {
            //scanner to read from file
            fileReader= new Scanner(mapInfo);

            //read line by line until none left
            while(fileReader.hasNext()) {

                //parse info
                String nextLine = fileReader.nextLine();
                String parts[] = nextLine.split(" ");
                int id = Integer.parseInt(parts[0]);

                Room toEdit = getRoomByID(id); //get the room we need to update info for adjacent rooms

                //add all the rooms to the adj room list of toEdit
                for(int i=1; i<parts.length; i++) {
                    Room toAdjAdd = getRoomByID(Integer.parseInt(parts[i]));
                    toEdit.addToAdjacentRooms(toAdjAdd);
                }
            }
        }catch(IOException e) { //handle checked exception
            e.printStackTrace();
        }finally {    //close scanner regardless of what happened for security reasons :)
            if(fileReader != null)
                fileReader.close();
        }
    }

    /**
     * Get the room objected associated with the given ID.
     * @param id the ID of the room to retrieve
     * @return the Room that corresponds to that id
     * @author Michelle
     */
    private Room getRoomByID(int id){
        int indexToEdit = roomList.indexOf(new Room(id,"dummy", null));
        Room toEdit = roomList.get(indexToEdit);
        return toEdit;
    }

    /**
     * method to Load characters
     */
    private void loadCharacters() {
        System.out.println("Adding characters...");
        characters.add(new Character(getRoomByID(5),"KEYHOLDER"));
        characters.add(new Player(getRoomByID(1)));
        characters.add(new Dragon(getRoomByID(9)));
    }

    /**
     * draw the game play
     */
    @Override
    public void draw() {
        Player p = (Player) this.characters.get(1);
        Dragon d = (Dragon) this.characters.get(2);
        Character k = this.characters.get(0);
        p.getCurrentRoom().draw();
        if (p.isDragonNearby(d)) {
            System.out.println(Dragon.getDragonWarning());
        }
        if (p.isTreasureNearby()) {
            System.out.println(TreasureRoom.getTreasureWarning());
        }
        if (p.isPortalNearby()) {
            System.out.println(PortalRoom.getPortalWarning());
        }
        if (p.getCurrentRoom().equals(k.getCurrentRoom())) {
            p.obtainKey();
            System.out.println("KEY OBTAINED");
        }
        if (p.teleport()) {
            System.out.println("Teleport Successfully.");
        }
        if (this.isDragonTurn) {
            d.changeRoom(d.pickRoom());
            this.isDragonTurn = false;
        }
        if (p.getCurrentRoom() instanceof TreasureRoom && p.hasKey()) {
            this.gameState = 1;
            System.out.println("You win.");
        }
        if (p.getCurrentRoom().equals(d.getCurrentRoom())) {
            this.gameState = 2;
            System.out.println("You lost.");
        }
    }

    /**
     * override of keyPressed()
     */
    @Override
    public void keyPressed() {
        if (this.gameState == 1 || this.gameState == 2) {return;}
        Player p = (Player) this.characters.get(1);
        Dragon d = (Dragon) this.characters.get(2);
        Character k = this.characters.get(0);
        Room destination = null;
        for (Room r: this.roomList) {
            if (((int) this.key) - 48 == r.getID()){
                destination = r;
                break;
            }
        }
        if (p.changeRoom(destination)) {
            this.isDragonTurn = true;
        }
        else {
            System.out.println("Pick a valid room to move.");
        }
    }

    /**
     * This is the main method of the class
     * @param args
     */
    public static void main(String[] args) {
        PApplet.main("DragonTreasureGame");

    }
}
