package de.schulung.bibliothek.administration;

import de.schulung.bibliothek.media.Medium;

import java.util.ArrayList;
import java.util.List;

public class Bibliothek {
    private final List<Medium> mediums =  new ArrayList<>();

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
}
