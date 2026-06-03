package de.schulung.bibliothek.media;

import de.schulung.bibliothek.enums.Language;

public class Dvd extends Medium {
    private final String director;
    private final int length;

    public Dvd(int id, String title, Language language, int year, String director, int length) {
        super(id, title, language, year);
        this.director = director;
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Dvd{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", language=" + language +
                ", year=" + year +
                ", length=" + length +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
