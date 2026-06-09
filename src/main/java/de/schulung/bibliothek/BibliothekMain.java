package de.schulung.bibliothek;

import de.schulung.bibliothek.administration.Bibliothek;
import de.schulung.bibliothek.administration.Member;
import de.schulung.bibliothek.media.Medium;
import de.schulung.bibliothek.utilities.MediumGenerator;
import de.schulung.bibliothek.utilities.MemberGenerator;

public class BibliothekMain {
    public static void main(String[] args) {
        Bibliothek bibliothek = new Bibliothek();

        Medium book = MediumGenerator.generateBook(bibliothek.getNextMediumId());
        Medium book2 = MediumGenerator.generateBook(bibliothek.getNextMediumId());

        bibliothek.addToStock(book);
        bibliothek.addToStock(book2);
        bibliothek.addToStock(MediumGenerator.generateDvd(bibliothek.getNextMediumId()));
        bibliothek.addToStock(MediumGenerator.generateDvd(bibliothek.getNextMediumId()));
        bibliothek.addToStock(MediumGenerator.generateDvd(bibliothek.getNextMediumId()));
        bibliothek.addToStock(MediumGenerator.generateDvd(bibliothek.getNextMediumId()));
        bibliothek.addToStock(MediumGenerator.generateDvd(bibliothek.getNextMediumId()));
        bibliothek.addToStock(MediumGenerator.generateDvd(bibliothek.getNextMediumId()));

        Member admin = new Member("CBM", "Paul", "Müller", "2000-11-15", "admin@cbm.de");
        bibliothek.addMember(admin);

        Member member1 = MemberGenerator.generateMember(bibliothek.getNextMemberId());
        Member member2 = MemberGenerator.generateMember(bibliothek.getNextMemberId());
        Member member3 = MemberGenerator.generateMember(bibliothek.getNextMemberId());
        bibliothek.addMember(member1);
        bibliothek.addMember(member2);
        bibliothek.addMember(member3);

        BibliothekConsole repl = new BibliothekConsole(bibliothek);
        repl.start();
    }
}
