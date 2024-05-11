package studi.kasus.java.v2.entity;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private int year;
    private int availableCopies;

    public Book(String title, String author, String ISBN, int year, int availableCopies) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.year = year;
        this.availableCopies = availableCopies;
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

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
}
