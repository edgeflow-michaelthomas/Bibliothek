package de.schulung.bibliothek.media;

import de.schulung.bibliothek.enums.Language;

public class Book extends Medium {
    private final String isbn;
    private final String author;
    private final int pages;

    public Book(int id, String title, Language language, int year, String isbn, String author, int pages) {
        super(id, title, language, year);
        this.isbn = isbn;
        this.author = author;
        this.pages = pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", language=" + language +
                ", year=" + year +
                ", isbn='" + isbn + '\'' +
                ", pages=" + pages +
                ", isAvailable=" + isAvailable +
                '}';
    }

    @Override
    public String generateInfoString() {
        return super.generateInfoString() + ", Author: " + author + ", Pages: " + pages + ", ISBN: " + isbn;
    }
}
