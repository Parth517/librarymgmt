package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

public class LibraryManagementSystemTest {
    private LibraryManagementSystem libraryManagementSystem;
    private Books book1;

    @Before
    public void setup() {
        libraryManagementSystem = new LibraryManagementSystem();
    }
    @Test
    public void shouldAddBook(){
        book1=new Books("Effective Coding","Abc","1234567891234",2018);
        libraryManagementSystem.addBook(book1);
        assertTrue(libraryManagementSystem.getBooksInLibrary().contains(book1));
    }

    @Test 
    public void shouldReturnExceptionWhenIncorrectNumberOfDetailsAreAdded() throws invalidBookDetailsException{
        new Books("Effective Coding","Abc","1234567891234");
     }
}
