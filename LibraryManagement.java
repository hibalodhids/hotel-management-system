import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    public Book(int id, String title, String author, boolean isIssued) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = isIssued;
    }

    public void display() {
        String status = isIssued ? "Issued" : "Available";
        System.out.printf("ID: %d, Title: %s, Author: %s, Status: %s%n",
                id, title, author, status);
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[100];
        int count = 0;
        int choice;

        
        books[count++] = new Book(1, "Java Programming", "John Doe", false);
        books[count++] = new Book(2, "Data Structures", "Jane Smith", true);
        books[count++] = new Book(3, "OOP Concepts", "Alice Johnson", false);

        do {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add new book");
            System.out.println("2. Show all books");
            System.out.println("3. Search book by title");
            System.out.println("4. Issue a book");
            System.out.println("5. Return a book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    if (count < books.length) {
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); 

                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();

                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();

                        books[count++] = new Book(id, title, author, false);
                        System.out.println("Book added successfully.");
                    } else {
                        System.out.println("Array is full.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- All Books ---");
                    for (int i = 0; i < count; i++) {
                        books[i].display();
                    }
                    break;

                case 3:
                    scanner.nextLine();
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (books[i].title.equalsIgnoreCase(searchTitle)) {
                            books[i].display();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter book ID to issue: ");
                    int issueId = scanner.nextInt();
                    boolean issued = false;

                    for (int i = 0; i < count; i++) {
                        if (books[i].id == issueId) {
                            if (books[i].isIssued) {
                                System.out.println("Book already issued.");
                            } else {
                                books[i].isIssued = true;
                                System.out.println("Book issued successfully.");
                            }
                            issued = true;
                            break;
                        }
                    }
                    if (!issued) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter book ID to return: ");
                    int returnId = scanner.nextInt();
                    boolean returned = false;

                    for (int i = 0; i < count; i++) {
                        if (books[i].id == returnId) {
                            if (!books[i].isIssued) {
                                System.out.println("Book is already available.");
                            } else {
                                books[i].isIssued = false;
                                System.out.println("Book returned successfully.");
                            }
                            returned = true;
                            break;
                        }
                    }
                    if (!returned) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        scanner.close();
    }
}
