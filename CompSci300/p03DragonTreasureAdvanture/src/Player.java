public class Player {
    private Room currentRoom;
    public Player(Room currentRoom) {this.currentRoom = currentRoom;}

    public Room getCurrentRoom() {return this.currentRoom;}

    public void changeRooms(Room newRoom) {this.currentRoom = newRoom;}

    public boolean canMoveTo(Room destination) {return this.currentRoom.isAdjacent(destination);}

    public boolean shouldTeleport() {return this.currentRoom.getType() == RoomType.PORTAL;}

    public boolean isDragonNearby(Dragon d) {return this.currentRoom.isAdjacent(d.getCurrentRoom());}

    public boolean isPortalNearby() {
        for (int i = 0; i < this.currentRoom.getAdjacentRooms().size(); ++i) {
            if (this.currentRoom.getAdjacentRooms().get(i).getType() == RoomType.PORTAL) {return true;}
        }
        return false;
    }

    public boolean isTreasureNearby() {
        for (int i = 0; i < this.currentRoom.getAdjacentRooms().size(); ++i) {
            if (this.currentRoom.getAdjacentRooms().get(i).getType() == RoomType.TREASURE) {return true;}
        }
        return false;
    }
}
