package dev.mqxf.library;

import java.util.HashMap;
import java.util.Map;

public class Author {

    private static Map<String, Author> authors = new HashMap<>();

    private String name;

    private Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Author getAuthor(String name) {
        //Check if author exists
        if (authors.containsKey(name)) {
            //Author exists, return author
            return authors.get(name);
        }
        else {
            //Author does not exist, create new author
            Author author = new Author(name);
            //Save author and return it
            authors.put(name, author);
            return author;
        }
    }
}