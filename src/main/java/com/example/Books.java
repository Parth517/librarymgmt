package com.example;

public class Books {

    private String title;
    private String author;
    private String isbn;
    private int publicationYear;

    public Books(String title, String author, String isbn, int publicationYear) throws invalidBookDetailsException{
        if(title==null||title.isEmpty()||
            author==null||author.isEmpty()||
            isbn==null||isbn.isEmpty()||
            publicationYear<=0){
                throw new invalidBookDetailsException("All details must be filled");
            }
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
}

