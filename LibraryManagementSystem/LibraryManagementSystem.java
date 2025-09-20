import java.util.ArrayList;
import java.util.Scanner;

// Book class
class Book {
    private String id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true; // book is available by default
    }

    public String getId() {
        return id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("✅ You have borrowed: " + title);
        } else {
            System.out.println("⚠️ Book is already borrowed!");
        }
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("✅ You have returned: " + title);
        } else {
            System.out.println("⚠️ Book was not borrowed!");
        }
    }

    public void displayInfo() {
        System.out.println("\nBook ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Borrowed"));
    }
}

// Main Library Management System
public class LibraryManagementSystem {
    private static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Library Management System ====");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. View All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // flush

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();
                    books.add(new Book(id, title, author));
                    System.out.println("✅ Book added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Book ID to borrow: ");
                    String borrowId = sc.nextLine();
                    Book borrowBook = findBookById(borrowId);
                    if (borrowBook != null) borrowBook.borrowBook();
                    else System.out.println("⚠️ Book not found!");
                    break;

                case 3:
                    System.out.print("Enter Book ID to return: ");
                    String returnId = sc.nextLine();
                    Book returnBook = findBookById(returnId);
                    if (returnBook != null) returnBook.returnBook();
                    else System.out.println("⚠️ Book not found!");
                    break;

                case 4:
                    if (books.isEmpty()) System.out.println("No books found.");
                    else {
                        for (Book b : books) b.displayInfo();
                    }
                    break;

                case 5:
                    System.out.println("👋 Exiting system. Goodbye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("⚠️ Invalid choice!");
            }
        }
    }

    private static Book findBookById(String id) {
        for (Book b : books) {
            if (b.getId().equals(id)) return b;
        }
        return null;
    }
}
