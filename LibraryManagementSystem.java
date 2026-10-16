import java.util.ArrayList;
import java.util.Scanner;

// Book Class representing individual book details
class Book {
    int bookId;
    String title;
    String author;
    boolean isAvailable;

    // Constructor
    
    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true; // By default, book is available
    }

    // Method to display book details
    public void displayBookInfo() {
        System.out.println("ID: " + bookId + " | Title: " + title + " | Author: " + author + 
                           " | Status: " + (isAvailable ? "Available" : "Issued"));
    }
}

// Member Class representing library members
class Member {
    int memberId;
    String name;

    // Constructor
    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    // Method to display member details
    public void displayMemberInfo() {
        System.out.println("Member ID: " + memberId + " | Name: " + name);
    }
}

// Main Library Management System Class
public class LibraryManagementSystem {
    private static ArrayList<Book> bookList = new ArrayList<>();
    private static ArrayList<Member> memberList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        // Adding some initial sample data
        bookList.add(new Book(101, "Java Programming", "James Gosling"));
        bookList.add(new Book(102, "Data Structures", "Mark Allen"));
        memberList.add(new Member(1, "Mokshagna"));
        memberList.add(new Member(2, "Sathwik"));

        do {
            System.out.println("\n========================================");
            System.out.println("    COMMUNITY LIBRARY MANAGEMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Add New Book");
            System.out.println("2. View All Books");
            System.out.println("3. Register Member");
            System.out.println("4. View All Members");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    registerMember();
                    break;
                case 4:
                    viewMembers();
                    break;
                case 5:
                    issueBook();
                    break;
                case 6:
                    returnBook();
                    break;
                case 7:
                    System.out.println("Exiting system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 7.");
            }
        } while (choice != 7);
    }

    // Method to add a book
    public static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine();

        bookList.add(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    // Method to view all books
    public static void viewBooks() {
        System.out.println("\n--- Library Book Inventory ---");
        if (bookList.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }
        for (Book b : bookList) {
            b.displayBookInfo();
        }
    }

    // Method to register a member
    public static void registerMember() {
        System.out.print("Enter Member ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Member Name: ");
        String name = scanner.nextLine();

        memberList.add(new Member(id, name));
        System.out.println("Member registered successfully!");
    }

    // Method to view all members
    public static void viewMembers() {
        System.out.println("\n--- Registered Library Members ---");
        if (memberList.isEmpty()) {
            System.out.println("No members registered yet.");
            return;
        }
        for (Member m : memberList) {
            m.displayMemberInfo();
        }
    }

    // Method to issue a book
    public static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int bookId = scanner.nextInt();

        Book foundBook = null;
        for (Book b : bookList) {
            if (b.bookId == bookId) {
                foundBook = b;
                break;
            }
        }

        if (foundBook == null) {
            System.out.println("Book not found!");
        } else if (!foundBook.isAvailable) {
            System.out.println("Sorry, this book is already issued!");
        } else {
            foundBook.isAvailable = false;
            System.out.println("Book issued successfully!");
        }
    }

    // Method to return a book
    public static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int bookId = scanner.nextInt();

        Book foundBook = null;
        for (Book b : bookList) {
            if (b.bookId == bookId) {
                foundBook = b;
                break;
            }
        }

        if (foundBook == null) {
            System.out.println("Book not found!");
        } else if (foundBook.isAvailable) {
            System.out.println("This book was not issued.");
        } else {
            foundBook.isAvailable = true;
            System.out.println("Book returned successfully!");
        }
    }
}
