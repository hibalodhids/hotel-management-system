import java.util.Scanner;

class Student {
    int id;
    String name;
    int roomNumber;

    public Student(int id, String name, int roomNumber) {
        this.id = id;
        this.name = name;
        this.roomNumber = roomNumber;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Room: " + roomNumber);
    }
}

public class StudentHostelManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[100]; // Max 100 students
        int count = 0;
        int choice;

        do {
            System.out.println("\n=== Student Hostel Management ===");
            System.out.println("1. Add new student");
            System.out.println("2. Show all students");
            System.out.println("3. Find student by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (count < students.length) {
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter room number: ");
                        int room = scanner.nextInt();
                        students[count] = new Student(id, name, room);
                        count++;
                        System.out.println("Student added successfully.");
                    } else {
                        System.out.println("Cannot add more students. Array full.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- All Students ---");
                    for (int i = 0; i < count; i++) {
                        students[i].display();
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID to search: ");
                    int searchId = scanner.nextInt();
                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (students[i].id == searchId) {
                            students[i].display();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}