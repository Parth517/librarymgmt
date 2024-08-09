package com.example;

import java.util.List;

public interface BookManager {
    void addBook(Books book);
    List<Books> getBooksInLibrary();

}
