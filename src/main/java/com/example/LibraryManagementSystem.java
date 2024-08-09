package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibraryManagementSystem implements BookManager {

    private final List<Books> booksInLibrary = new ArrayList<>();
    private final BookInventory bookInventory;

    public LibraryManagementSystem(BookInventory bookInventory) {
        this.bookInventory = bookInventory;
    }

    @Override
    public void addBook(Books book) {
        booksInLibrary.add(book);
        bookInventory.countBook(book);
    }

    @Override
    public List<Books> getBooksInLibrary() {
        return Collections.unmodifiableList(booksInLibrary);
    }

    public int countCopiesByIsbn(String isbn) {
        return bookInventory.countCopiesByIsbn(isbn);
    }

    public void borrowBook(String isbn) throws bookNotAvailableException {
        int availCopies = bookInventory.countCopiesByIsbn(isbn);
        if (availCopies <= 0) {
            throw new bookNotAvailableException("The requested book is not available");
        }
        booksInLibrary.removeIf(book -> book.getIsbn().equals(isbn));
        bookInventory.decrementBookCount(isbn);
    }

    public void returnBook(Books book){
        booksInLibrary.add(book);
        bookInventory.incrementBookCount(book.getIsbn());
    }

    public List<Books> viewAllAvailableBooks(){
        return Collections.unmodifiableList(booksInLibrary);
    }
}
