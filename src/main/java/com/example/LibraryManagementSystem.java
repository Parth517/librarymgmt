package com.example;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {

    private String title;
    private String author;
    private String isbn;
    private int publicationYear;

    private static List<LibraryManagementSystem> BooksInLibrary = new ArrayList<>();

    public LibraryManagementSystem(String title, String author, String isbn, int publicationYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void addBook(LibraryManagementSystem libraryManagementSystem) {
        BooksInLibrary.add(libraryManagementSystem);
        System.out.println("Book added Successfully " + libraryManagementSystem.getTitle());
    }

    public static List<LibraryManagementSystem> getBooksInLibrary(){
        return BooksInLibrary;
    }
}
