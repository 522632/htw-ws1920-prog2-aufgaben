package de.htwberlin.prog2.ws1920.reisen;

import java.util.Scanner;

import javax.swing.JFrame;

import de.htwberlin.prog2.ws1920.reisen.entities.Adresse;
import de.htwberlin.prog2.ws1920.reisen.entities.Reiseagentur;
import de.htwberlin.prog2.ws1920.reisen.entities.Reservierung;
import de.htwberlin.prog2.ws1920.reisen.ui.MainFrame;
import de.htwberlin.prog2.ws1920.reisen.util.Init;
import de.htwberlin.prog2.ws1920.reisen.util.Validator;

public class Starter {

    private static Scanner scan = new Scanner(System.in);
    private static Reiseagentur magicHolidays;
    private static final boolean GUI = true;

    public static void main(String[] args) {

        magicHolidays = new Reiseagentur("Magic Holidays Reiseagentur", "DE812524001");
        magicHolidays.setAdresse(new Adresse("Hauptstraße", "5a", "10559", "Berlin"));
        Init.initReiseagentur(magicHolidays);

        if (GUI) {
            JFrame frame = new MainFrame(magicHolidays);
            frame.setVisible(true);
        } else {
            System.out.println(magicHolidays);
            while (true) {
                showMenue();
                int choice = readUserInput();
                processUserInput(choice);
            }
        }
    }

    private static void showMenue() {

        String menuEntries[] = { "Privatkunde anlegen", "Geschäftskunde anlegen",
                "Reservierung anlegen und Kundennummer zuordnen",
                "Kunde mit Reservierungen anzeigen (Auswahl durch Kundennummer)",
                "Kunde mit Reservierungen anzeigen (Auswahl durch Name)",
                "Reservierung anzeigen (Auswahl durch Reservierungsnummer)", "Beenden" };

        System.out.println("Menü");
        System.out.println("=====");

        for (int i = 0; i < menuEntries.length; i++) {
            System.out.println((i + 1) + ".\t" + menuEntries[i]);
        }

    }

    private static int readUserInput() {

        int choice = -1;

        System.out.print("Auswahl:" + "\t");

        if (scan.hasNextLine()) {
            String stringChoice = scan.nextLine();
            try {

                choice = Integer.parseInt(stringChoice);
            } catch (NumberFormatException nfe) {
                System.err.println(nfe.getMessage());
            }
        }
        System.out.println();

        return choice;
    }

    private static void processUserInput(int choice) {

        switch (choice) {
        case 1:
            privatkundeAnlegen();
            break;
        case 2:
            geschaeftskundeAnlegen();
            break;
        case 3:
            reservierungAnlegen();
            break;
        case 4:
            kundenDurchNummerSuchen();
            break;
        case 5:
            kundenDurchNameSuchen();
            break;
        case 6:
            reservierungSuchen();
            break;
        case 7:
            quitApp();
            break;
        default: {
            System.out.println("Invalider Input!");
            scan.reset();
        }

        }
    }

    /**
     * 
     */
    private static void reservierungSuchen() {
        System.out.println("Reservierung anzeigen (Auswahl durch Reservierungsnummer)");
        System.out.print("Reservierungsnummer:\t");
        long reservierungsnummer = -1;
        String reservierungsnummerAlsString = scan.nextLine();
        try {
            reservierungsnummer = Long.parseLong(reservierungsnummerAlsString);
        } catch (NumberFormatException exc) {
            System.err.println("Invalider Input " + reservierungsnummerAlsString);
            processUserInput(6);
            return;
        }

        boolean isValidInput = Validator.isValidReservierungsnummer(reservierungsnummer);
        if (!isValidInput) {
            System.err.println("Reservierungsnummer " + reservierungsnummer + " ist ungueltig");
            processUserInput(6);
            return;
        }

        Reservierung reservierung = magicHolidays.reservierungSuchen("" + reservierungsnummer);
        if (reservierung == null)
            System.out.println("Reservierung mit der Reservierungsnummer " + reservierungsnummerAlsString
                    + " koennte nicht gefunden werden");
        else
            System.out.println(reservierung);

    }

    /**
     * 
     */
    private static void kundenDurchNameSuchen() {
        // TODO Auto-generated method stub

    }

    /**
     * 
     */
    private static void kundenDurchNummerSuchen() {
        // TODO Auto-generated method stub

    }

    /**
     * 
     */
    private static void reservierungAnlegen() {
        // TODO Auto-generated method stub

    }

    /**
     * 
     */
    private static void geschaeftskundeAnlegen() {
        // TODO Auto-generated method stub

    }

    /**
     * 
     */
    private static void privatkundeAnlegen() {
        // TODO Auto-generated method stub

    }

    private static void quitApp() {
        scan.close();
        System.exit(0);
    }

}
//