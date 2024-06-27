package com.techelevator;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PurchaseMenu {
    private VendingMachine vendingMachine;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public PurchaseMenu(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Current Money Provided: $" + df.format(vendingMachine.getCurrentMoney()));
            System.out.println("(1) Feed Money");
            System.out.println("(2) Select Item");
            System.out.println("(3) End Transaction");
            System.out.println("Enter your choice: ");

            try {
                int selection = scanner.nextInt();
                if (selection == 1) {
                    System.out.println("Insert money amount: ");
                    double amount = scanner.nextDouble();
                    vendingMachine.feedMoney(amount);
                } else if (selection == 2) {
                    System.out.println("Enter item slot location: ");
                    String slotId = scanner.next();
                    vendingMachine.selectItem(slotId.toUpperCase());
                } else if (selection == 3) {
                    vendingMachine.endTransaction();
                    break;
                } else {
                    System.out.println("Invalid selection, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid selection, please try again.");
                scanner.next();
            }
        }
    }
}
