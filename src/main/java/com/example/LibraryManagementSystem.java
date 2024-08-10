package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryManagementSystem implements BookManager {
    private final BookInventory bookInventory;
    private final Map<String, Books> booksInLibrary = new HashMap<>();

    public LibraryManagementSystem(BookInventory bookInventory) {
        this.bookInventory = bookInventory;
    }

    @Override
    public void addBook(Books book) {
        String isbn = book.getIsbn();
        if (!booksInLibrary.containsKey(isbn)) {
            booksInLibrary.put(isbn, book);
        }
        bookInventory.countBook(book);
    }

    @Override
    public List<Books> getBooksInLibrary() {
        return Collections.unmodifiableList(new ArrayList<>(booksInLibrary.values()));
    }

    public int countCopiesByIsbn(String isbn) {
        return bookInventory.countCopiesByIsbn(isbn);
    }

    public void borrowBook(String isbn) throws bookNotAvailableException {
        int availCopies = bookInventory.countCopiesByIsbn(isbn);
        if (availCopies <= 0) {
            throw new bookNotAvailableException("The requested book is not available");
        }
        booksInLibrary.remove(isbn);
        bookInventory.decrementBookCount(isbn);
    }

    public void returnBook(Books book) {
        String isbn = book.getIsbn();
        booksInLibrary.put(isbn, book);
        bookInventory.incrementBookCount(isbn);
    }

    public List<Books> viewAllAvailableBooks() {
        return Collections.unmodifiableList(new ArrayList<>(booksInLibrary.values()));
    }
}