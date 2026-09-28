import java.util.ArrayList;

class Book {
    String bookId;
    String title;
    String author;
    boolean isAvailable;

    // Constructor to initialize a book
    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true; // By default, a new book is available
    }

    // Method to display book details
    public void displayInfo() {
        String status = isAvailable ? "Available" : "Checked Out";
        System.out.println("[" + bookId + "] " + title + " by " + author + " — Status: " + status);
    }
}
