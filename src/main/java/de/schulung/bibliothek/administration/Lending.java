package de.schulung.bibliothek.administration;

import de.schulung.bibliothek.media.Medium;

import java.time.LocalDate;

public class Lending {
    private final LocalDate lendingDate;
    private final Medium medium;

    public Lending(LocalDate lendingDate, Medium medium) {
        this.lendingDate = lendingDate;
        this.medium = medium;
    }

    @Override
    public String toString() {
        return "Lending{" +
                "lendingDate=" + lendingDate +
                ", medium=" + medium +
                '}';
    }
}
