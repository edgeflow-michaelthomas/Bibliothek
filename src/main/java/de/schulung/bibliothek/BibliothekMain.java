package de.schulung.bibliothek;

import de.schulung.bibliothek.administration.Bibliothek;
import de.schulung.bibliothek.media.Medium;
import de.schulung.bibliothek.utilities.MediumGenerator;

public class BibliothekMain {
    public static void main(String[] args) {
        Bibliothek bibliothek = new Bibliothek();

        Medium book = MediumGenerator.generateBook(bibliothek.getNextId());
        Medium book2 = MediumGenerator.generateBook(bibliothek.getNextId());

        bibliothek.addToStock(book);
        bibliothek.addToStock(book2);
        bibliothek.addToStock(MediumGenerator.generateDvd(bibliothek.getNextId()));
        bibliothek.addToStock(MediumGenerator.generateDvd(bibliothek.getNextId()));
        bibliothek.addToStock(MediumGenerator.generateDvd(bibliothek.getNextId()));
        bibliothek.addToStock(MediumGenerator.generateDvd(bibliothek.getNextId()));
        bibliothek.addToStock(MediumGenerator.generateDvd(bibliothek.getNextId()));
        bibliothek.addToStock(MediumGenerator.generateDvd(bibliothek.getNextId()));

        bibliothek.printStock();
    }
}
