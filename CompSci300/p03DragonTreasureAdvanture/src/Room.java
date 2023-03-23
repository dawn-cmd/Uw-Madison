import java.util.ArrayList;
import java.util.Objects;

public class Room {
    private RoomType type;
    private String roomDescription;
    private ArrayList<Room> adjRooms;
    private final int ID;
    private static int teleportLocationID;
    private static final String PORTAL_WARNING = "You feel a distortion in space nearby.\n";
    private static final String TREASURE_WARNING = "You sense that there is treasure nearby.\n";

    public Room(int id, String roomDescription) {
        this.ID = id;
        this.roomDescription = roomDescription;
        this.type = RoomType.NORMAL;
        this.adjRooms = new ArrayList<Room>();
    }

    public RoomType getType() {return this.type;}

    public int getID() {return this.ID;}

    public ArrayList<Room> getAdjacentRooms() {return this.adjRooms;}

    public String getRoomDescription() {return this.roomDescription;}

    public void setRoomType(RoomType newType) {this.type = newType;}

    public void addToAdjacentRooms(Room toAdd) {this.adjRooms.add(toAdd);}

    public boolean isAdjacent(Room r) {
        for (int i = 0; i < this.adjRooms.size(); ++i) {
            if (this.adjRooms.get(i).equals(r)) {return true;}
        }
        return false;
    }

    public static void assignTeleportLocation(int teleportID) {teleportLocationID = teleportID;}

    public static String getPortalWarning() {return PORTAL_WARNING;}

    public static String getTreasureWarning() {return TREASURE_WARNING;}

    public static int getTeleportationRoom() {return teleportLocationID;}



    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Room)) {return false;}
        Room otherRoom = (Room) other;
        return this.ID == otherRoom.ID;
    }

    @Override
    public String toString() {
        String s = this.ID + ": " + this.roomDescription + " (" + type + ")\n Adjacent Rooms: ";
        for (int i = 0; i < adjRooms.size(); ++i) {
            s += adjRooms.get(i).ID + " ";
        }
        return s;
    }
}
