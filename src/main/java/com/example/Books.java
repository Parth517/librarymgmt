package com.example;

public class Books {

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
