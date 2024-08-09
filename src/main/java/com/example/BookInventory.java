package com.example;

public interface BookInventory {
    void countBook(Books book);
    int countCopiesByIsbn(String isbn);
    int decrementBookCount(String isbn);
    void incrementBookCount(String isbn);
}