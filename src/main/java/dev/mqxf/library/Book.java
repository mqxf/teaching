package dev.mqxf.library;

public class Book extends Document {

    public Book(String id, String title, Author author) {
        super(id, title, author);
    }

    @Override
    public String getContents() {
        return null;
    }

    @Override
    public String toString() {
        return String.format("\"%s\" by %s", title, author.getName());
    }
}


// class Book
// extends Document
//
// id
// title
// author
//
// constructor Book(id, title, author)
// getters and setters
// super(id, title, author, "Book")
//
// @override toString()
// print title + author