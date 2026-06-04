package de.schulung.bibliothek.utilities;

import de.schulung.bibliothek.administration.Member;
import net.datafaker.Faker;

import java.util.Random;

public class MemberGenerator {
    private static final Faker faker = new Faker();
    private static final Random random = new Random();

    public static Member generateMember(int id) {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String memberId = String.valueOf(id) + firstName.charAt(0) + lastName.charAt(0);
        int year = random.nextInt(1960, 2007);
        String month = String.valueOf(random.nextInt(12) + 1);
        if (month.length() == 1) {
            month = "0" + month;
        }
        String day = String.valueOf(random.nextInt(28) + 1);
        if (day.length() == 1) {
            day = "0" + day;
        }

        String birthDate = year + "-" + month + "-" + day;
        String email = faker.internet().emailAddress();
        return new Member(memberId, firstName, lastName, birthDate, email);
    }
}
