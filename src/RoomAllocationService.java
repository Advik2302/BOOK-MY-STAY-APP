import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ***************************************************************
 * CLASS - RoomAllocationService
 * ***************************************************************
 * 
 * Use Case 6: Reservation Confirmation & Room Allocation
 * 
 * Description:
 * This class is responsible for confirming 
 * booking requests and assigning rooms.
 * 
 * It ensures:
 * - Each room ID is unique
 * - Inventory is updated immediately
 * - No room is double booked
 * 
 * @version 6.0
 */
public class RoomAllocationService {

    /**
     * Stores all allocated room IDs to
     * prevent duplicate assignments.
     */
    private Set<String> allocatedRoomIds;

    /**
     * Stores assigned room IDs by room type.
     * 
     * Key   -> Room type
     * Value -> Set of assigned room IDs
     */
    private Map<String, Set<String>> assignedRoomsByType;

    /**
     * Initializes allocation tracking structures.
     */
    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    /**
     * Confirms a booking request by assigning
     * a unique room ID and updating inventory.
     * 
     * @param reservation booking request
     * @param inventory   centralized room inventory
     */
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String roomType = reservation.getRoomType();
        int available = inventory.getRoomAvailability().getOrDefault(roomType, 0);

        if (available > 0) {
            String roomId = generateRoomId(roomType);
            
            allocatedRoomIds.add(roomId);
            
            assignedRoomsByType.putIfAbsent(roomType, new HashSet<>());
            assignedRoomsByType.get(roomType).add(roomId);
            
            inventory.updateAvailability(roomType, available - 1);
            
            System.out.println("Booking confirmed for Guest: " + reservation.getGuestName()
                + ", Room ID: " + roomId);
        } else {
            System.out.println("Booking failed for Guest: " + reservation.getGuestName() 
                + " - No " + roomType + " rooms available.");
        }
    }

    /**
     * Generates a unique room ID
     * for the given room type.
     * 
     * @param roomType type of room
     * @return unique room ID
     */
    private String generateRoomId(String roomType) {
        int nextId = 1;
        if (assignedRoomsByType.containsKey(roomType)) {
            nextId = assignedRoomsByType.get(roomType).size() + 1;
        }
        return roomType + "-" + nextId;
    }
}
