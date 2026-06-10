package de.schulung.bibliothek.administration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BibliothekTest {

    private Bibliothek bibliothek;
    private Member admin = new Member("CBM", "Paul", "Müller", "2000-11-15", "admin@cbm.de");

    @BeforeEach
    public void setup(){
        bibliothek = new Bibliothek();
    }

    @Test
    void addMember() {
        assertTrue(bibliothek.addMember(admin), "Member added successfully");
    }

    @Test
    void addDuplicateMember() {
        bibliothek.addMember(admin);

        assertFalse(bibliothek.addMember(admin), "Member already exists");
    }

    @Test
    void findMemberById() {
        bibliothek.addMember(admin);

        assertEquals(admin, bibliothek.findMemberById("CBM"), "Member found");
    }
}
