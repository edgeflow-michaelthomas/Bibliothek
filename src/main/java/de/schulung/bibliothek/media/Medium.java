package de.schulung.bibliothek.media;

import de.schulung.bibliothek.enums.Language;

public abstract class Medium {
    protected final int id;
    protected final String title;
    protected final Language language;
    protected final int year;

    protected boolean isAvailable;

    public Medium(int id, String title, Language language, int year) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.year = year;
        this.isAvailable = true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Language getLanguage() {
        return language;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String generateInfoString() {
        return "ID: " + getId() + ", Available: " + isAvailable() + ", Type: " + getClass().getSimpleName() + ", Title: " + getTitle() + ", Language: " + getLanguage() + ", Year: " + getYear();
    }
}
