import java.util.Scanner;


class Room {
    int roomNumber;
    String type;
    double price;
    boolean isBooked; 

     
    public Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.isBooked = false; 
    }

    
    public void displayRoom() {
        String status = isBooked ? "Booked" : "Available";
        System.out.println("Room #" + roomNumber + " | Type: " + type + 
                           " | Price: $" + price + " | Status: " + status);
    }
}

public class HotelManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Room[] rooms = new Room[10]; // Array 
        int roomCount = 0;
        int choice;

        System.out.println("--- Hotel Management System ---");

        do {
            System.out.println("\n1. Add New Room");
            System.out.println("2. Show All Rooms");
            System.out.println("3. Show Available Rooms Only");
            System.out.println("4. Book a Room");
            System.out.println("5. Check-out");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: // newRoom
                    if (roomCount < rooms.length) {
                        System.out.print("Enter Room Number: ");
                        int rNum = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        System.out.print("Enter Room Type (Single/Double/Suite): ");
                        String rType = scanner.nextLine();
                        System.out.print("Enter Price: ");
                        double rPrice = scanner.nextDouble();

                        rooms[roomCount] = new Room(rNum, rType, rPrice);
                        roomCount++;
                        System.out.println("Room added successfully!");
                    } else {
                        System.out.println("Hotel is at full capacity (cannot add more rooms).");
                    }
                    break;

                case 2: // Show All Rooms
                    System.out.println("\n--- All Rooms ---");
                    for (int i = 0; i < roomCount; i++) {
                        rooms[i].displayRoom();
                    }
                    break;

                case 3: // Show Available Rooms Only
                    System.out.println("\n--- Available Rooms ---");
                    for (int i = 0; i < roomCount; i++) {
                        if (!rooms[i].isBooked) {
                            rooms[i].displayRoom();
                        }
                    }
                    break;

                case 4: // Book a Room
                    System.out.print("Enter Room Number to book: ");
                    int bookNum = scanner.nextInt();
                    boolean foundBook = false;
                    for (int i = 0; i < roomCount; i++) {
                        if (rooms[i].roomNumber == bookNum) {
                            foundBook = true;
                            if (!rooms[i].isBooked) {
                                rooms[i].isBooked = true;
                                System.out.println("Room " + bookNum + " booked successfully!");
                            } else {
                                System.out.println("Room is already booked.");
                            }
                            break;
                        }
                    }
                    if (!foundBook) System.out.println("Room not found.");
                    break;

                case 5: // Check-out
                    System.out.print("Enter Room Number for check-out: ");
                    int checkOutNum = scanner.nextInt();
                    boolean foundOut = false;
                    for(int i = 0; i< roomCount; i++){
                        if(rooms[i].roomNumber == checkOutNum){
                            foundOut = true;
                            rooms[i].isBooked = false ;
                            System.out.println("Check Out Successfully. Room"+ checkOutNum + "is now avialable.");
                            break;
                        }
                    }
                    if(!foundOut) System.out.println("Room not found.");
                    break;

                    case 6:
                        System.out.println("Existing system.");
                        break;

                    default:
                        System.out.println("Invalid choice! Try again");
                }       
            }while (choice != 6);
            scanner.close();
    }
}
