package com.techelevator;

public class Application {
    public static void main(String[] args) {
        asciiArt();
        VendingMachine vendingMachine = new VendingMachine();
        MainMenu mainMenu = new MainMenu(vendingMachine);
        mainMenu.showMenu();

    }


    private static void asciiArt() {
        System.out.println("  ____  _   _    _    ____ _  __ _ ");
        System.out.println(" / ___|| \\ | |  / \\  / ___| |/ /| |");
        System.out.println(" \\___ \\|  \\| | / _ \\| |   | ' / | |");
        System.out.println("  ___) | |\\  |/ ___ \\ |___| . \\ |_|");
        System.out.println(" |____/|_| \\_/_/   \\_\\____|_|\\_\\(_)");
        System.out.println("    |: {🍬} {🧁} {🍪} {🍩} :|");
        System.out.println("    |: {🥫} {🍫} {🧃} {🍭} :|");
        System.out.println("    |:                 [{}] :|");
        System.out.println("    |:   _________________  :|");
        System.out.println("    |:  |_________________| :|");
        System.out.println("    |:                      :|");
        System.out.println("    |•       [Welcome!]     •|");
        System.out.println("    |________________________|\n");

    }
}