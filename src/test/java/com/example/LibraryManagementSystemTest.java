package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

public class LibraryManagementSystemTest {
    private LibraryManagementSystem libraryManagementSystem;

    @BeforeEach
    public void setup() {
        libraryManagementSystem = new LibraryManagementSystem("Effective Coding","Abc","1234567891234",2018);
    }
    @Test
    public void shouldAddBook(){
        libraryManagementSystem.addBook(book1);
        assertTrue(libraryManagementSystem.getBooksInLibrary().contains(book1));
    }
}
