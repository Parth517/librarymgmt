package com.example;

import java.util.regex.Pattern;

public class Books {
    private static final String ISBN_REGEX="^978-\\d-\\d{3}-\\d{5}\\-\\d$";
    private static final Pattern ISBN_PATTERN=Pattern.compile(ISBN_REGEX);


    private final String title;
    private final String author;
    private final String isbn;
    private final int publicationYear;

    public Books(String title, String author, String isbn, int publicationYear) throws invalidBookDetailsException {
        validateBookDetails(title, author, isbn, publicationYear);
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
    }

    private void validateBookDetails(String title, String author, String isbn, int publicationYear) throws invalidBookDetailsException {
        if (title == null || title.isEmpty() ||
            author == null || author.isEmpty() ||
            isbn == null || isbn.isEmpty() ||
            publicationYear <= 0) {
            throw new invalidBookDetailsException("All details must be filled");
        }
        if(!ISBN_PATTERN.matcher(isbn).matches()){
            throw new invalidBookDetailsException("ISBN must be in the format 978-0-596-52068-7");

        }
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}
