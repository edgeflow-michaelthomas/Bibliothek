package de.schulung.bibliothek.administration;

import java.time.LocalDate;

public class Member {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;

    // Datumsformat: YYYY-MM-DD
    public Member(String id, String firstName, String lastName, String birthDateString, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = LocalDate.parse(birthDateString);
        this.email = email;
    }
}


/*
Aufgaben:
TODO: Überlegt, welche Form für die ID im Mitglied sinnvoll ist
TODO: Implementiert die Member.java-Klasse zu Ende
TODO: Testet das Erstellen von Mitgliedern
TODO: Fügt Mitgliederverwaltung in die Bibliothek hinzu
TODO: Erstellt einen Mitgliedergenerator

TODO: Implementiert das Ausleihen von Medien
*/
