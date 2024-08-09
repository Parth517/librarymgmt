package com.example;

public interface BookInventory {
    void countBook(Books book);
    int countCopiesByIsbn(String isbn);

}