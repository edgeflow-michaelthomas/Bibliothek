package de.schulung.bibliothek;

import java.util.Scanner;

public class BibliothekConsole {
    private boolean running = false;
    private Scanner input;

    public void start() {
        running = true;
        input = new Scanner(System.in);

        while(running) {
            System.out.print("> ");

            // 1. Read

            String line = input.nextLine();

            // 2. Evaluate & 3. Print
            evaluate(line);

        }

        input.close();
    }

    private void evaluate(String line) {
        // lend, return, register member, quit, help
        if (line.equalsIgnoreCase("quit")) {
            running = false;
            System.out.println("Bis zum nächsten Mal!");
        }
    }
}
