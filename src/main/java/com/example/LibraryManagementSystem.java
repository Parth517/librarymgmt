package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryManagementSystem {

    private static List<Books> BooksInLibrary = new ArrayList<>();
    Map<String, Integer> countNumberOfBooks = new HashMap<>();

    public void addBook(Books book) {
        BooksInLibrary.add(book);
        countBooks(book);
    }

    public void countBooks(Books book) {
        countNumberOfBooks.put(book.getIsbn(), countNumberOfBooks.getOrDefault(book.getIsbn(), 0) + 1);
    }

    public static List<Books> getBooksInLibrary() {
        return BooksInLibrary;
    }

    public int countCopiesByIsbn(String isbn) {
        return countNumberOfBooks.getOrDefault(isbn, 0);
    }
}
