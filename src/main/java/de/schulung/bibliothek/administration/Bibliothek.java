package de.schulung.bibliothek.administration;

import de.schulung.bibliothek.exceptions.NotMemberOfTheLibraryException;
import de.schulung.bibliothek.exceptions.NotRegisteredMediumException;
import de.schulung.bibliothek.media.Medium;

import java.time.LocalDate;
import java.util.*;

public class Bibliothek {
    private final Set<Medium> mediums =  new HashSet<>();
    private final Set<Member> members =  new HashSet<>();

    private final Map<Member, List<Lending>> lendings =  new HashMap<>();

    private int currentMediumId = 0;
    private int currentMemberId = 0;

    public boolean addToStock(Medium medium){
        if (!mediums.contains(medium)) {
            mediums.add(medium);
            return true;
        }
        return false;
    }

    public boolean removeFromStock(Medium medium){
        return mediums.remove(medium);
    }

    public void printStock() {
        for (Medium medium : mediums) {
            System.out.println(medium);
        }
    }

    public boolean addMember(Member member) {
        return members.add(member);
    }

    public boolean removeMember(Member member) {
        return members.remove(member);
    }

    public void printMembers() {
        for (Member member : members) {
            System.out.println(member);
        }
    }

    public int getNextMediumId() {
        currentMediumId++;
        return currentMediumId;
    }

    public int getNextMemberId() {
        currentMemberId++;
        return currentMemberId;
    }

    public Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }

    public List<Lending> getLendings(Member member) {
        return lendings.get(member);
    }

    public boolean lendMedium(Member member, Medium medium, LocalDate lendingDate) throws NotMemberOfTheLibraryException, NotRegisteredMediumException{
        /*
        1. Member gibt es
        2. Medium gibt es
        3. Medium ist nicht ausgeliehen
         */

        if (!members.contains(member)) {
            throw new NotMemberOfTheLibraryException(member.getFirstName() + " " + member.getLastName() + " is not registered at this library");
        }

        if (!mediums.contains(medium)) {
            throw new NotRegisteredMediumException(medium.getTitle() + " is not a registered medium at this library");
        }

        if (!medium.isAvailable()) {
            System.out.println(medium.getTitle() + " is already lent");
            return false;
        }

        if (!lendings.containsKey(member)) {
            lendings.put(member, new ArrayList<>());
        }

        Lending lending = new Lending(lendingDate, medium);
        lendings.get(member).add(lending);
        medium.setAvailable(false);

        return true;
    }

    public boolean returnMedium(Member member, Medium medium) throws NotMemberOfTheLibraryException, NotRegisteredMediumException{
        if (!members.contains(member)) {
            throw new NotMemberOfTheLibraryException(member.getFirstName() + " " + member.getLastName() + " is not registered at this library");
        }

        if (!mediums.contains(medium)) {
            throw new NotRegisteredMediumException(medium.getTitle() + " is not a registered medium at this library");
        }

        if (!lendings.containsKey(member)) {
            return false;
        }

        // variante A - mit for-each Schleife
        List<Lending> memberLending = lendings.get(member);
        for (Lending lending : memberLending) {
            if (lending.getMedium().equals(medium)) {
                memberLending.remove(lending);
                medium.setAvailable(true);

                // Wenn Mitglied nichts mehr ausgeliehen hat, dann entferne Eintrag aus Lendings-Map
                if (lendings.get(member).isEmpty()) {
                    lendings.remove(member);
                }

                return true;
            }
        }
        return false;

        // variante B - mit Lambdas
//        boolean found = lendings.get(member).removeIf(lending -> lending.getMedium().equals(medium));
//        if(found) {
//
//            medium.setAvailable(true);
//            // Wenn Mitglied nichts mehr ausgeliehen hat, dann entferne Eintrag aus Lendings-Map
//            if (lendings.get(member).isEmpty()) {
//                lendings.remove(member);
//            }
//        }
//
//        return found;
    }
}
