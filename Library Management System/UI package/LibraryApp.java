//The LibraryApp class manages the user interaction via the command-line interface.
package ui;

import models.Book;
import models.LibraryItem;
import models.Magazine;
import services.Library;

import java.time.LocalDate;
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Library Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. List Items");
            System.out.println("4. Find Item by Title");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Book ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    library.addItem(new Book(id, title, author, isbn));
                }
                case 2 -> {
                    System.out.print("Enter Magazine ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Issue Date (YYYY-MM-DD): ");
                    LocalDate issueDate = LocalDate.parse(scanner.nextLine());
                    library.addItem(new Magazine(id, title, issueDate));
                }
                case 3 -> library.listItems().forEach(item -> System.out.println(item.getDetails()));
                case 4 -> {
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    LibraryItem item = library.findItemByTitle(title);
                    System.out.println(item != null ? item.getDetails() : "Item not found.");
                }
                case 5 -> {
                    System.out.print("Enter Book Title to Borrow: ");
                    String title = scanner.nextLine();
                    LibraryItem item = library.findItemByTitle(title);
                    if (item instanceof Book book && book.isAvailable()) {
                        book.borrow();
                    } else {
                        System.out.println("Book is not available or is not borrowable.");
                    }
                }
                case 6 -> {
                    System.out.print("Enter Book Title to Return: ");
                    String title = scanner.nextLine();
                    LibraryItem item = library.findItemByTitle(title);
                    if (item instanceof Book book && !book.isAvailable()) {
                        book.returnItem();
                    } else {
                        System.out.println("Book is already available.");
                    }
                }
                case 7 -> exit = true;
                default -> System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}