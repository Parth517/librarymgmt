package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class LibraryManagementSystemTest {

    private LibraryManagementSystem libraryManagementSystem;
    private Books book1;

    @Before
    public void setup() {
        libraryManagementSystem = new LibraryManagementSystem();
    }

    @Test
    public void shouldAddBook() {
        try {
            book1 = new Books("Effective Coding", "Abc", "1234567891234", 2018);
            libraryManagementSystem.addBook(book1);
            assertTrue(libraryManagementSystem.getBooksInLibrary().contains(book1));
        } catch (invalidBookDetailsException e) {
            fail("Exception should not be thrown for valid book details");
        }
    }

    @Test
    public void shouldReturnExceptionWhenIncorrectNumberOfDetailsAreAdded() {
        try {
            new Books("Effective Coding", "Abc", "1234567891234", 0);
            fail("Expected an invalidBookDetailsException to be thrown");
        } catch (invalidBookDetailsException e) {
            assertEquals("All details must be filled", e.getMessage());
        }
    }

    @Test
    public void shouldReturnExceptionWhenAuthorNameIsMissing() {
        try {
            new Books("Effective Coding", "", "1234567891234", 2011);
            fail("Expected an invalidBookDetailsException to be thrown");
        } catch (invalidBookDetailsException e) {
            assertEquals("All details must be filled", e.getMessage());
        }
    }
    @Test
    public void shouldReturnExceptionWhenBookNameIsMissing() {
        try {
            new Books("", "Abc", "1234567891234", 2011);
            fail("Expected an invalidBookDetailsException to be thrown");
        } catch (invalidBookDetailsException e) {
            assertEquals("All details must be filled", e.getMessage());
        }
    }
    @Test
    public void shouldReturnExceptionWhenIsbnIsMissing() {
        try {
            new Books("Book Title", "Abc", "", 2011);
            fail("Expected an invalidBookDetailsException to be thrown");
        } catch (invalidBookDetailsException e) {
            assertEquals("All details must be filled", e.getMessage());
        }
    }
    @Test
    public void shouldReturnExceptionWhenAllDetailsAreMissing() {
        try {
            new Books("", "", "",0);
            fail("Expected an invalidBookDetailsException to be thrown");
        } catch (invalidBookDetailsException e) {
            assertEquals("All details must be filled", e.getMessage());
        }
    }
}
