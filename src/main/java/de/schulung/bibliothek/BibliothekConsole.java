package de.schulung.bibliothek;

import de.schulung.bibliothek.administration.Bibliothek;
import de.schulung.bibliothek.administration.Member;

import java.util.Locale;
import java.util.Scanner;

public class BibliothekConsole {
    private boolean running = false;
    private Scanner input;
    private Bibliothek bibliothek;
    private Member currentUser = null;

    public BibliothekConsole(Bibliothek bibliothek) {
        this.bibliothek = bibliothek;
    }

    public void start() {
        running = true;
        input = new Scanner(System.in);

        printHelp();

        while(running) {
            if (currentUser == null) {
                System.out.print("> ");
            } else {
                System.out.print(currentUser.getId() + " > ");
            }

            // 1. Read
            String line = input.nextLine();

            // 2. Evaluate & 3. Print
            evaluate(line);
        }

        input.close();
    }

    private void printHelp() {
        String helpLoggedIn =
                """
                        How to use the Bibliothek?
                        Available commands:
                            logout:        Log out the current user
                            quit:          Exit the program
                            list:          List complete medium stock
                            help:          Show this help page""";

        String helpNoUser =
                """
                        How to use the Bibliothek?
                        Available commands:
                            login userId:  Log in the user with the provided user id
                            quit:          Exit the program
                            list:          List complete medium stock
                            help:          Show this help page""";

        if (currentUser == null) {
            System.out.println(helpNoUser);
        } else {
            System.out.println(helpLoggedIn);
        }
    }

    private void quit() {
        running = false;
        System.out.println("Bis zum nächsten Mal!");
    }

    private void listMediums() {
        bibliothek.printStock();
    }

    private void login(String userId) {
        if (currentUser != null) {
            System.out.println(currentUser.getId() + " is already logged in");
            return;
        }

        Member member = bibliothek.findMemberById(userId);
        if (member == null) {
            System.out.println("Invalid user ID!");
            return;
        }
        currentUser = member;
        System.out.println("Login successful");
    }

    private void logout() {
        if (currentUser == null) {
            System.out.println("No user logged in!");
            return;
        }

        currentUser = null;
        System.out.println("Logout successful");
    }

    private void evaluate(String line) {
        // lend, return, quit, help, list, login, logout, (register member)
        String[] tokens = line.split(" ");
        String command = tokens[0].toLowerCase();

        String arg = null;
        if (tokens.length > 1) {
            arg = tokens[1];
        }

        switch (command) {
            // z.B. login 3KP
            case "login" -> login(arg);
            case "logout" -> logout();
            case "quit" -> quit();
            case "list" -> listMediums();
            case "help" -> printHelp();
            default -> System.out.println("Unrecognized command");
        }
    }
}
