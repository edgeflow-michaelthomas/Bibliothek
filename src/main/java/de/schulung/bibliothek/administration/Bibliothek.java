package de.schulung.bibliothek.administration;

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

    public boolean lendMedium(Member member, Medium medium, LocalDate lendingDate) {
        /*
        1. Member gibt es
        2. Medium gibt es
        3. Medium ist nicht ausgeliehen
         */

        if (members.contains(member) && mediums.contains(medium) && medium.isAvailable()) {
            if (!lendings.containsKey(member)) {
                lendings.put(member, new ArrayList<>());
            }

            Lending lending = new Lending(lendingDate, medium);
            lendings.get(member).add(lending);
            medium.setAvailable(false);

            return true;
        }
        return false;
    }

    public boolean returnMedium(Member member, Medium medium) {
        lendings.containsKey(member);
    }
}
