/**
 * ***************************************************************
 * MAIN CLASS - UseCase2RoomInitialization
 * ***************************************************************
 * Use Case 2: Basic Room Types & Static Availability
 * 
 * Description:
 * This class demonstrates room initialization
 * using domain models before introducing
 * centralized inventory management.
 * 
 * Availability is represented using
 * static variables to highlight limitations.
 * 
 * @version 2.0
 */
public class UseCase2RoomInitialization {
    /**
     * Application entry point.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hotel Room Initialization\n");

        Room singleRoom = new SingleRoom();
        int singleAvailable = 5;
        System.out.println("Single Room:");
        singleRoom.displayRoomDetails();
        System.out.println("Available: " + singleAvailable + "\n");

        Room doubleRoom = new DoubleRoom();
        int doubleAvailable = 3;
        System.out.println("Double Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleAvailable + "\n");

        Room suiteRoom = new SuiteRoom();
        int suiteAvailable = 2;
        System.out.println("Suite Room:");
        suiteRoom.displayRoomDetails();
        System.out.println("Available: " + suiteAvailable + "\n");
    }
}
