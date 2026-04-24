package library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Library lib = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add Book\n2.Add User\n3.Show Books\n4.Show Users\n5.Issue Book\n6.Return Book\n7.Show Issued\n8.Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Book ID: ");
                    int bid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    lib.addBook(new Book(bid, title, author));
                    break;

                case 2:
                    System.out.print("User ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    lib.addUser(new User(uid, name));
                    break;

                case 3:
                    lib.showBooks();
                    break;
                    
                case 4:
                    lib.showUsers();
                    break;

                case 5:
                    System.out.print("Book ID: ");
                    int b = sc.nextInt();
                    System.out.print("User ID: ");
                    int u = sc.nextInt();
                    lib.issueBook(b, u);
                    break;

                case 6:
                    System.out.print("Book ID: ");
                    int rb = sc.nextInt();
                    lib.returnBook(rb);
                    break;

                case 7:
                    lib.showIssuedBooks();
                    break;

                case 8:
                    System.exit(0);
            }
        }
    }
}