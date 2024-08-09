package com.example;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {


    private static List<Books> BooksInLibrary = new ArrayList<>();

    public void addBook(Books book) {
        BooksInLibrary.add(book);
        System.out.println("Book added Successfully " + book.getTitle());
    }

    public static List<Books> getBooksInLibrary() {
        return BooksInLibrary;
    }
}
