package library;

import java.util.*;

public class Library {

    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<IssueRecord> issuedBooks = new ArrayList<>();

    // Add Book
    public void addBook(Book book) {
        books.add(book);
    }

    // Add User
    public void addUser(User user) {
        users.add(user);
    }

    // Show Books
    public void showBooks() {
        for (Book b : books) {
            b.display();
        }
    }

    // Show Users
    public void showUsers() {
        for (User u : users) {
            u.display();
        }
    }

    // Issue Book
    public void issueBook(int bookId, int userId) {
        Book book = findBook(bookId);
        User user = findUser(userId);

        if (book == null || user == null) {
            System.out.println("Invalid Book/User");
            return;
        }

        if (book.isIssued()) {
            System.out.println("Book already issued!");
            return;
        }

        book.issueBook();
        issuedBooks.add(new IssueRecord(book, user));

        System.out.println("Book issued successfully!");
    }

    // Return Book
    public void returnBook(int bookId) {
        Book book = findBook(bookId);

        if (book == null || !book.isIssued()) {
            System.out.println("Invalid return!");
            return;
        }

        book.returnBook();

        issuedBooks.removeIf(r -> r.getBook().getId() == bookId);

        System.out.println("Book returned!");
    }

    // Find Book
    private Book findBook(int id) {
        for (Book b : books) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    // Find User
    private User findUser(int id) {
        for (User u : users) {
            if (u.getId() == id) return u;
        }
        return null;
    }

    // Show Issued Books
    public void showIssuedBooks() {
        for (IssueRecord r : issuedBooks) {
            r.display();
        }
    }
}
