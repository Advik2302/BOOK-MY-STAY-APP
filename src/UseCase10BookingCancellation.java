/**
 * ***************************************************************
 * MAIN CLASS - UseCase10BookingCancellation
 * ***************************************************************
 * 
 * Use Case 10: Booking Cancellation & Inventory Rollback
 * 
 * Description:
 * This class demonstrates how confirmed
 * bookings can be cancelled safely.
 * 
 * Inventory is restored and rollback
 * history is maintained.
 * 
 * @version 10.0
 */
public class UseCase10BookingCancellation {

    /**
     * Application entry point.
     * 
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Booking Cancellation\n");

        RoomInventory inventory = new RoomInventory();
        CancellationService cancellationService = new CancellationService();

        // Simulate confirmed bookings
        cancellationService.registerBooking("Single-1", "Single");
        cancellationService.registerBooking("Single-2", "Single");

        // Cancel a booking
        cancellationService.cancelBooking("Single-1", inventory);

        // Display Rollback History
        cancellationService.showRollbackHistory();

        // Display updated inventory
        System.out.println("\nUpdated Single Room Availability: " 
            + inventory.getRoomAvailability().get("Single"));
    }
}
