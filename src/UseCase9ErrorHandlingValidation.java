import java.util.Scanner;

/**
 * ***************************************************************
 * MAIN CLASS - UseCase9ErrorHandlingValidation
 * ***************************************************************
 * 
 * Use Case 9: Error Handling & Validation
 * 
 * Description:
 * This class demonstrates how user input
 * is validated before booking is processed.
 * 
 * The system:
 * - Accepts user input
 * - Validates input strictly
 * - Handles errors gracefully
 * 
 * @version 9.0
 */
public class UseCase9ErrorHandlingValidation {

    /**
     * Application entry point.
     * 
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Display Application header
        System.out.println("Booking Validation\n");

        Scanner scanner = new Scanner(System.in);

        // Initialize required components
        RoomInventory inventory = new RoomInventory();
        ReservationValidator validator = new ReservationValidator();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        try {
            System.out.print("Enter guest name: ");
            String guestName = scanner.nextLine();

            System.out.print("Enter room type (Single/Double/Suite): ");
            String roomType = scanner.nextLine();

            // Validate Input BEFORE creating reservation
            validator.validate(guestName, roomType, inventory);

            // If valid, create and queue the reservation
            Reservation newReservation = new Reservation(guestName, roomType);
            bookingQueue.addRequest(newReservation);
            System.out.println("Booking for " + guestName + " strictly placed in queue!");

        } catch (InvalidBookingException e) {
            // Handle domain-specific validation errors
            System.out.println("Booking failed: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
