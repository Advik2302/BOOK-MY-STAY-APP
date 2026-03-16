/**
 * ***************************************************************
 * MAIN CLASS - UseCase7AddOnServiceSelection
 * ***************************************************************
 * 
 * Use Case 7: Add-On Service Selection
 * 
 * Description:
 * This class demonstrates how optional
 * services can be attached to a confirmed
 * booking.
 * 
 * Services are added after room allocation
 * and do not affect inventory.
 * 
 * @version 7.0
 */
public class UseCase7AddOnServiceSelection {

    /**
     * Application entry point.
     * 
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Add-On Service Selection\n");

        AddOnServiceManager serviceManager = new AddOnServiceManager();

        // Create available add-on services
        AddOnService breakfast = new AddOnService("Breakfast", 500.0);
        AddOnService wifi = new AddOnService("Premium WiFi", 200.0);
        AddOnService spa = new AddOnService("Spa Access", 1500.0);

        // Assume a confirmed reservation ID
        String reservationId = "Single-1";

        // Attach services
        serviceManager.addService(reservationId, breakfast);
        serviceManager.addService(reservationId, wifi);

        // Display results
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + serviceManager.calculateTotalServiceCost(reservationId));
    }
}
