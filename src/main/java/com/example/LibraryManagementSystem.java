package com.example;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {


    private static List<Books> BooksInLibrary = new ArrayList<>();
    private static List<String[]> countNumberOfBooks = new ArrayList<>();

    public void addBook(Books book) {
        BooksInLibrary.add(book);
        boolean found=false;
        //count number of books if book is already in countNumberOfBooks
        for (String[] entry : countNumberOfBooks) {
            if (entry[0].equals(book.getIsbn())) {
                entry[1] = String.valueOf(Integer.parseInt(entry[1]) + 1);
                found = true;
                break;
            }
        }
        if(!found){
            countNumberOfBooks.add(new String[]{book.getIsbn(),"1"});
        }
        System.out.println("Book added Successfully " + book.getTitle());
    }

    public static List<Books> getBooksInLibrary() {
        return BooksInLibrary;
    }

    public int countCopiesByIsbn(String isbn){
        for(String[] entry:countNumberOfBooks){
            if (entry[0].equals(isbn)) {
                return Integer.parseInt(entry[1]);
            }
        }
        return 0;
    }
}
