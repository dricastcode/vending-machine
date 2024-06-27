package com.techelevator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    private VendingMachine vendingMachine;

    public MainMenu(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("(1) Display Vending Items");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");
            // System.out.println("(4) Generate Sales Report");
            System.out.println("\n Enter your selection: ");

            try {
                int select = scanner.nextInt();
                if (select == 1) {
                    vendingMachine.displayItems();
                } else if (select == 2) {
                    PurchaseMenu purchaseMenu = new PurchaseMenu(vendingMachine);
                    purchaseMenu.displayMenu();
                } else if (select == 3) {
                    System.out.println("Goodbye!");
                    System.exit(0);
                } else if (select == 4) {
                    SalesReport.generateReport(vendingMachine);
                } else {
                    System.out.println("Invalid selection!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid selection!");
                scanner.next();
            }
        }
    }


}
