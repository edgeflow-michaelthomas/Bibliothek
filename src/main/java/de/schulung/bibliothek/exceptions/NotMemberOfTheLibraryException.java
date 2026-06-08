package de.schulung.bibliothek.exceptions;

public class NotMemberOfTheLibraryException extends Exception {
    public NotMemberOfTheLibraryException(String message) {
        super(message);
    }
}
