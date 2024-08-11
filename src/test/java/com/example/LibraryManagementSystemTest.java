package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class LibraryManagementSystemTest {

    private LibraryManagementSystem libraryManagementSystem;
    private Books book1;
    private Books book2;

    @Before
    public void setup() {
        // Initialize the LibraryManagementSystem with a SimpleBookInventory instance
        libraryManagementSystem = new LibraryManagementSystem(new SimpleBookInventory());
    }

    @Test
    public void shouldAddBook() {
        try {
            book1 = new Books("Effective Coding", "Abc", "978-0-596-52068-7", 2018);
            libraryManagementSystem.addBook(book1);
            assertTrue(libraryManagementSystem.getBooksInLibrary().contains(book1));

            // Ensure getters are called and executed
            assertEquals("Effective Coding", book1.getTitle());
            assertEquals("Abc", book1.getAuthor());
            assertEquals("978-0-596-52068-7", book1.getIsbn());
            assertEquals(2018, book1.getPublicationYear());

        } catch (invalidBookDetailsException e) {
            fail("Exception should not be thrown for valid book details");
        }
    }

    @Test
    public void shouldThrowExceptionForInvalidIsbnPattern() {
        try {
            // ISBN with invalid pattern
            new Books("Effective Coding", "Abc", "123-4-567-891234-0", 2018);
            fail("Expected an invalidBookDetailsException to be thrown due to invalid ISBN pattern");
        } catch (invalidBookDetailsException e) {
            assertEquals("ISBN must be in the format 978-0-596-52068-7", e.getMessage());
        }

        try {
            // Another invalid ISBN pattern
            new Books("Effective Coding", "Abc", "978-0-596-52068", 2018);
            fail("Expected an invalidBookDetailsException to be thrown due to invalid ISBN pattern");
        } catch (invalidBookDetailsException e) {
            assertEquals("ISBN must be in the format 978-0-596-52068-7", e.getMessage());
        }
    }

    @Test
    public void shouldReturnExceptionWhenIncorrectNumberOfDetailsAreAdded() {
        try {
            new Books("Effective Coding", "Abc", "978-0-596-52068-7", 0);
            fail("Expected an InvalidBookDetailsException to be thrown");
        } catch (invalidBookDetailsException e) {
            assertEquals("All details must be filled", e.getMessage());
        }
    }

    @Test
    public void shouldReturnExceptionWhenAuthorNameIsMissing() {
        try {
            new Books("Effective Coding", "", "978-0-596-52068-7", 2011);
            fail("Expected an InvalidBookDetailsException to be thrown");
        } catch (invalidBookDetailsException e) {
            assertEquals("All details must be filled", e.getMessage());
        }
    }

    @Test
    public void shouldReturnExceptionWhenBookNameIsMissing() {
        try {
            new Books("", "Abc", "978-0-596-52068-7", 2011);
            fail("Expected an InvalidBookDetailsException to be thrown");
        } catch (invalidBookDetailsException e) {
            assertEquals("All details must be filled", e.getMessage());
        }
    }

    @Test
    public void shouldReturnExceptionWhenTitleIsNull() {
        try {
            new Books(null, "Abc", "978-0-596-52068-7", 2011);
            fail("Expected an InvalidBookDetailsException to be thrown");
        } catch (invalidBookDetailsException e) {
            assertEquals("All details must be filled", e.getMessage());
        }
    }

    @Test
    public void shouldReturnExceptionWhenIsbnIsMissing() {
        try {
            new Books("Book Title", "Abc", "", 2011);
            fail("Expected an InvalidBookDetailsException to be thrown");
        } catch (invalidBookDetailsException e) {
            assertEquals("All details must be filled", e.getMessage());
        }
    }

    @Test
    public void shouldReturnExceptionWhenAllDetailsAreMissing() {
        try {
            new Books("", "", "", 0);
            fail("Expected an InvalidBookDetailsException to be thrown");
        } catch (invalidBookDetailsException e) {
            assertEquals("All details must be filled", e.getMessage());
        }
    }

    @Test
    public void shouldReturnExceptionWhenIsbnIsInvalid() {
        try {
            new Books("Effective Coding", "Abc", "1234567891234", 2018);
            fail("Expected an InvalidBookDetailsException to be thrown");
        } catch (invalidBookDetailsException e) {
            assertEquals("ISBN must be in the format 978-0-596-52068-7", e.getMessage());
        }
    }

    @Test
    public void shouldBorrowBookWhenAvailable() {
        try {
            book1 = new Books("Effective Coding", "Abc", "978-0-596-52068-7", 2018);
            libraryManagementSystem.addBook(book1);
            libraryManagementSystem.borrowBook("978-0-596-52068-7");
            assertEquals(0, libraryManagementSystem.countCopiesByIsbn("978-0-596-52068-7"));
        } catch (invalidBookDetailsException | bookNotAvailableException e) {
            fail("Exception should not be raised here");
        }
    }

    @Test
    public void shouldNotBorrowBookWhenBookIsNotAvailable() {
        try {
            libraryManagementSystem.borrowBook("978-0-596-52068-7");
            fail("Expected an Error when book that doesn't exist is tried to be borrowed");
        } catch (bookNotAvailableException e) {
            assertEquals("The requested book is not available", e.getMessage());
        }
    }

    @Test
    public void shouldCheckIfCountIsDecrementedTo0AfterBorrowing() {
        try {
            book1 = new Books("Effective Coding", "Abc", "978-0-596-52068-7", 2018);
            libraryManagementSystem.addBook(book1);
            // Ensure book is added and count is correct
            assertEquals(1, libraryManagementSystem.countCopiesByIsbn("978-0-596-52068-7"));
            libraryManagementSystem.borrowBook("978-0-596-52068-7");
            assertEquals(0, libraryManagementSystem.countCopiesByIsbn("978-0-596-52068-7"));
        } catch (bookNotAvailableException | invalidBookDetailsException e) {
            fail("Exception should not be raised here");
        }
    }

    @Test
    public void shouldNotRemoveAnyBookWhenIsbnDoesntMatch() {
        try {
            book1 = new Books("Effective Coding", "Abc", "978-0-596-52068-7", 2018);
            libraryManagementSystem.addBook(book1);
            assertEquals(1, libraryManagementSystem.countCopiesByIsbn("978-0-596-52068-7"));
            libraryManagementSystem.borrowBook("111-1-2345-6789-0"); // Incorrect ISBN format

            fail("Book not available exception should be raised here");
        } catch (bookNotAvailableException e) {
            assertEquals(1, libraryManagementSystem.countCopiesByIsbn("978-0-596-52068-7"));
            assertEquals(0, libraryManagementSystem.countCopiesByIsbn("111-1-2345-6789-0"));
        } catch (invalidBookDetailsException e) {
            fail("Exception should not be raised here");
        }
    }

    @Test
    public void shouldDecrementCountWhenBookIsAvailable() {
        try {
            book1 = new Books("Effective Coding", "Abc", "978-0-596-52068-7", 2018);
            libraryManagementSystem.addBook(book1);
            libraryManagementSystem.addBook(book1);
            assertEquals(2, libraryManagementSystem.countCopiesByIsbn("978-0-596-52068-7"));

            libraryManagementSystem.borrowBook("978-0-596-52068-7");
            assertEquals(1, libraryManagementSystem.countCopiesByIsbn("978-0-596-52068-7"));
            libraryManagementSystem.borrowBook("978-0-596-52068-7");
            assertEquals(0, libraryManagementSystem.countCopiesByIsbn("978-0-596-52068-7"));
        } catch (invalidBookDetailsException | bookNotAvailableException e) {
            fail("Exception should not be raised here");
        }
    }

    @Test
    public void shouldReturnBookAndIncrementCount() {
        try {
            book1 = new Books("Effective Coding", "Abc", "978-0-596-52068-7", 2018);
            libraryManagementSystem.addBook(book1);
            libraryManagementSystem.borrowBook("978-0-596-52068-7");
            assertEquals(0, libraryManagementSystem.countCopiesByIsbn("978-0-596-52068-7"));

            // Return the book
            libraryManagementSystem.returnBook(book1);
            assertEquals(1, libraryManagementSystem.countCopiesByIsbn("978-0-596-52068-7"));
        } catch (invalidBookDetailsException | bookNotAvailableException e) {
            fail("Exception should not be raised here");
        }
    }

    @Test
    public void shouldViewAllAvailableBooks() {
        try {
            // Add two books to the library
            book1 = new Books("Effective Coding", "Abc", "978-0-596-52068-7", 2018);
            book2 = new Books("Clean Code", "Xyz", "978-1-234-56789-7", 2019);

            libraryManagementSystem.addBook(book1);
            libraryManagementSystem.addBook(book2);

            // Get the list of all available books
            List<Books> availableBooks = libraryManagementSystem.viewAllAvailableBooks();

            // Verify that the list contains both books
            assertEquals(2, availableBooks.size());
            assertTrue(availableBooks.contains(book1));
            assertTrue(availableBooks.contains(book2));
        } catch (invalidBookDetailsException e) {
            fail("Exception should not be thrown for valid book details");
        }
    }

    @Test
    public void shouldViewAllAvailableBooksWhenNoneAreAdded() {
        List<Books> availableBooks = libraryManagementSystem.viewAllAvailableBooks();
        assertTrue(availableBooks.isEmpty());
    }
    
    @Test
    public void shouldManageMultipleBooksWithDifferentIsbn() {
        try {
            book1 = new Books("Effective Coding", "Abc", "978-0-596-52068-7", 2018);
            book2 = new Books("Clean Code", "Xyz", "978-1-234-56789-7", 2019);
            libraryManagementSystem.addBook(book1);
            libraryManagementSystem.addBook(book2);
            
            libraryManagementSystem.borrowBook("978-0-596-52068-7");
            assertEquals(0, libraryManagementSystem.countCopiesByIsbn("978-0-596-52068-7"));
            assertEquals(1, libraryManagementSystem.countCopiesByIsbn("978-1-234-56789-7"));
            
            libraryManagementSystem.returnBook(book1);
            assertEquals(1, libraryManagementSystem.countCopiesByIsbn("978-0-596-52068-7"));
            assertEquals(1, libraryManagementSystem.countCopiesByIsbn("978-1-234-56789-7"));
        } catch (invalidBookDetailsException | bookNotAvailableException e) {
            fail("Exception should not be raised here");
        }
    }
  
}   

