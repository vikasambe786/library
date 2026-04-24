package library;

import java.time.LocalDate;

public class IssueRecord {
    private Book book;
    private User user;
    private LocalDate issueDate;

    public IssueRecord(Book book, User user) {
        this.book = book;
        this.user = user;
        this.issueDate = LocalDate.now();
    }

    public void display() {
        System.out.println("Book: " + book.getTitle() +
                " | User: " + user.getName() +
                " | Date: " + issueDate);
    }

    public Book getBook() {
        return book;
    }
}
