import java.util.ArrayList;

public class DragonTreasureTester {
    public static boolean testRoomInstanceMethods() {
        try {
            Room room = new Room(1, "01");
            if (room.getID() != 1) {return false;}
            if (room.getRoomDescription() != "01") {return false;}
            if (room.getType() != RoomType.NORMAL) {return false;}

            Room addRoom = new Room(2, "02");
            room.addToAdjacentRooms(addRoom);
            if (!room.isAdjacent(addRoom)) {
                System.out.println("add adjRoom wrong");
                return false;
            }
            if (!room.getAdjacentRooms().get(0).equals(addRoom)) {return false;}

            room.setRoomType(RoomType.START);
            if (room.getType() != RoomType.START) {
                System.out.println("set type wrong");
                return false;
            }

            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public static boolean testRoomStaticMethods() {
        try {
            Room room3 = new Room(3, "03");
            Room room4 = new Room(4, "04");
            room3.assignTeleportLocation(4);
            if (room3.getTeleportationRoom() != 4) {return false;}

            if (!room3.getPortalWarning().equals("You feel a distortion in space nearby.\n")) {return false;}
            if (!room3.getTreasureWarning().equals("You sense that there is treasure nearby.\n")) {return false;}

            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public static boolean testPlayerCanMoveTo() {
        try {
            Room room1 = new Room(1, "1");
            Room room2 = new Room(2, "2");
            room1.addToAdjacentRooms(room2);
            room2.addToAdjacentRooms(room1);
            Player player = new Player(room1);
            if (!player.canMoveTo(room2)) {return false;}
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public static boolean testPlayerShouldTeleport() {
        try {
            Room room1 = new Room(1, "1");
            room1.setRoomType(RoomType.PORTAL);
            Player player = new Player(room1);
            if (!player.shouldTeleport()) {return false;}
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public static boolean testPlayerDetectNearbyRooms() {
        try {
            Room room1 = new Room(1, "1");
            Room room2 = new Room(2, "2");
            Room room3 = new Room(3, "3");
            room2.setRoomType(RoomType.TREASURE);
            room3.setRoomType(RoomType.PORTAL);
            room1.addToAdjacentRooms(room2);
            room1.addToAdjacentRooms(room3);
            Player player = new Player(room1);
            if (!player.isTreasureNearby()) {return false;}
            if (!player.isPortalNearby()) {return false;}
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public static boolean testDragonChangeRooms() {
        try {
            Room room1 = new Room(1, "1");
            Room room2 = new Room(2, "2");
            Room room3 = new Room(3, "3");
            room1.addToAdjacentRooms(room2);
            room1.addToAdjacentRooms(room3);
            Dragon dragon = new Dragon(room1);
            dragon.changeRooms();
            if (!dragon.getCurrentRoom().equals(room2) && !dragon.getCurrentRoom().equals(room3)) {return false;}
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Test Room Instance Method: " + testRoomInstanceMethods());
        System.out.println("Test Room Static Method: " + testRoomStaticMethods());
        System.out.println("Test Player Can Move To method: " + testPlayerCanMoveTo());
        System.out.println("Test Player Should Teleport method: " + testPlayerShouldTeleport());
        System.out.println("Test Player Detect Nearby Rooms: " + testPlayerDetectNearbyRooms());
        System.out.println("Test Dragon Change Room: " + testDragonChangeRooms());
    }
}
