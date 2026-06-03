package de.schulung.bibliothek.utilities;

import de.schulung.bibliothek.enums.Language;
import de.schulung.bibliothek.media.Book;
import de.schulung.bibliothek.media.Medium;
import net.datafaker.Faker;

import java.util.Random;

public class MediumGenerator {
    private static final Faker faker = new Faker();
    private static final Random random = new Random();

    public static Medium generateBook(int id) {

        String title = faker.book().title();
        Language language = Language.ENGLISH;
        int year = random.nextInt(1900, 2026);
        String isbn = faker.code().isbn13(true);
        String author = faker.book().author();
        int pages = random.nextInt(200, 700);


        return new Book(id, title, language, year, isbn, author, pages);
    }
}
