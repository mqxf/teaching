package dev.mqxf.library;

import dev.mv.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Declare Main class
public class Main {

    List<Book> books = new ArrayList<>(); //List maps unique integer index to an Object
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        printMenu();
    }

    public void addBook() {
        //Get title and author
        String title = getTitle();
        Author author = getAuthor();
        //Make the id using title and author
        String id = author.getName().replaceAll("\\s+", "") + ":" + title.replaceAll("\\s+", "");
        Book book = new Book(id, title, author);
        //Add the book to the list
        books.add(book);
        System.out.println("'\nAdded the book \"" + title + "\" by \"" + author.getName() + "\" to the library.\n");
    }

    public void listBooks() {
        for (Book book : books) {
            System.out.println(book.toString());
        }
        System.out.println("Amount of books: " + books.size() + "\n");
    }

    public String getTitle() {
        try {
            //Get the input
            return safeGetString("Enter the book title: ");
        } catch (Exception e) {
            //This means the input is blank, so we ask the user again
            return getTitle();
        }
    }

    public Author getAuthor() {
        try {
            //Get the input as an author
            return Author.getAuthor(safeGetString("Enter the book author: "));
        } catch (Exception e) {
            //This means the input is blank, so we ask the user again
            return getAuthor();
        }
    }

    public String safeGetString(String prompt) {
        //Print the prompt out
        System.out.print(prompt);
        //Get the user input
        String input = sc.nextLine();
        if (input.isBlank()) {
            //If the input is blank, throw an exception
            throw new NullPointerException("Empty Input!");
        }
        return input;
    }

    //Create print menu
    public String printMenu () {
        //Menu string
        String menu = """
            1. List books
            2. Add book
            3. Exit
            Please make a selection:\s""";

        while (true) {
            //Print the menu
            System.out.print(menu);
            try {
                //Get the user input
                int input = Integer.parseInt(sc.nextLine());
                System.out.println();
                //Check the input
                switch (input) {
                    case 1 -> listBooks();
                    case 2 -> addBook();
                    case 3 -> System.exit(0);
                    default -> System.out.println("This is not a valid menu option! Please select a valid option.\n");
                }
            } catch (NumberFormatException e) {
                //Input was not a number, ask the user for new input
                System.out.println("\nNot a number, please enter a valid menu option.\n");
            }
        }
    }
}

//Need:
// - 4 Pillars of OOP
//   - Inheritance
//   - Polymorphism
//   - Encapsulation
//   - Abstraction
// - 3 Classes & Constructors
// - 4 Methods (not including main)
// - A Scanner
// - A switch statement
// - An exception handler
// - A collection
// - A loop over the collection
