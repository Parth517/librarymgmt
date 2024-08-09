package com.example;

import java.util.Map;
import java.util.HashMap;

public class SimpleBookInventory implements BookInventory {

    private final Map<String, Integer> countNumberOfBooks = new HashMap<>();

    @Override
    public void countBook(Books book) {
        countNumberOfBooks.put(book.getIsbn(), countNumberOfBooks.getOrDefault(book.getIsbn(), 0) + 1);
    }

    @Override
    public int countCopiesByIsbn(String isbn) {
        return countNumberOfBooks.getOrDefault(isbn, 0);
    }
    
}
