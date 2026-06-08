package de.schulung.bibliothek;

import de.schulung.bibliothek.administration.Bibliothek;
import de.schulung.bibliothek.administration.Member;
import de.schulung.bibliothek.media.Medium;
import de.schulung.bibliothek.utilities.MediumGenerator;
import de.schulung.bibliothek.utilities.MemberGenerator;

import java.time.LocalDate;

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

        bibliothek.printStock();

        Member member1 = MemberGenerator.generateMember(bibliothek.getNextMemberId());
        Member member2 = MemberGenerator.generateMember(bibliothek.getNextMemberId());
        Member member3 = MemberGenerator.generateMember(bibliothek.getNextMemberId());
        bibliothek.addMember(member1);
        bibliothek.addMember(member2);
        bibliothek.printMembers();

        bibliothek.lendMedium(member1, book, LocalDate.now());
        System.out.println();
        System.out.println(bibliothek.getLendings(member1));

//        System.out.println(book);
//        bibliothek.returnMedium(member1, book);
//        System.out.println(book);

        System.out.println(bibliothek.lendMedium(member3, book, LocalDate.now()));
    }
}
