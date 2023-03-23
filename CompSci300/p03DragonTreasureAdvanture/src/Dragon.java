import java.util.Random;

public class Dragon {
    private Room currentRoom;
    private Random randGen = new Random();
    private static final String DRAGON_WARNING = "You hear a fire breathing nearby!\n";

    public Dragon(Room currentRoom) {this.currentRoom = currentRoom;}

    public Room getCurrentRoom() {return this.currentRoom;}

    public void changeRooms() {
        int id = randGen.nextInt(this.currentRoom.getAdjacentRooms().size());
        while (this.currentRoom.getAdjacentRooms().get(id).getType() == RoomType.PORTAL) {
            id = randGen.nextInt(this.currentRoom.getAdjacentRooms().size());
        }
        this.currentRoom = this.currentRoom.getAdjacentRooms().get(id);
    }

    public static String getDragonWarning() {return DRAGON_WARNING;}
}
