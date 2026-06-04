package de.schulung.bibliothek.administration;

import de.schulung.bibliothek.media.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bibliothek {
    private final List<Medium> mediums =  new ArrayList<>();
    private final Set<Member> members =  new HashSet<>();
    private int currentMediumId = 0;
    private int currentMemberId = 0;


    public boolean addToStock(Medium medium){
        if (!mediums.contains(medium)){
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
}
