package com.techelevator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private Map<String, Item> items;
    private double currentMoney;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    private void itemsFromCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader("vendingmachine.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] item = line.split("\\|");
                String slotId = item[0];
                String name = item[1];
                double price = Double.parseDouble(item[2]);
                String type = item[3];
                items.put(slotId, new Item(slotId, name, price, 5, type));
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

    public VendingMachine() {
        this.items = new HashMap<>();
        this.currentMoney = 0.00;
        itemsFromCSV();
    }

    public double getCurrentMoney() {
        return currentMoney;
    }

    public Map<String, Item> getItems() {
        return items;
    }

    public void displayItems() {
        for (Item item : items.values()) {
            String toDisplay;
            if (item.getQuantity() > 0) {
                toDisplay = String.valueOf(item.getQuantity());
            } else {
                toDisplay = "SOLD OUT";
            }
            System.out.println(item.getSlotId() + " " + item.getName() + " $" + item.getPrice() + " | " + toDisplay);
        }
    }

    public void feedMoney(double amount) {
        currentMoney += amount;
        LogTransaction.log("Feed money: $" + amount + " $" + df.format(currentMoney));
    }

    public void selectItem(String slotId) {
        Item item = items.get(slotId);
        if (item != null) {
            if (item.getQuantity() > 0) {
                if (currentMoney >= item.getPrice()) {
                    item.dispense();
                    currentMoney -= item.getPrice();
                    LogTransaction.log(item.getName() + slotId + " $" + item.getPrice() + " $" + df.format(currentMoney));
                    String dispenseMessage = item.getMessage();
                    if (!dispenseMessage.isEmpty()) {
                        System.out.println(dispenseMessage);
                    }
                } else {
                    System.out.println("Insufficient funds");
                }
            } else {
                System.out.println("Sold out!");
            }
        } else {
            System.out.println("Invalid Slot");
        }
    }

    public void endTransaction() {
        double change = currentMoney;
        currentMoney = 0;
        LogTransaction.log("Change: $" + df.format(change) + " $" + df.format(currentMoney));
        returnChange(change);
    }

    private void returnChange(double change) {
        int quarters = (int) (change / 0.25);
        change %= 0.25;
        int dimes = (int) (change / 0.10);
        change %= 0.10;
        int nickels = (int) (change / 0.05);

        System.out.println("Change returned: $" + (quarters * 0.25 + dimes * 0.10 + nickels * 0.05));
        System.out.println("Quarters: " + quarters + ", Dimes: " + dimes + ", Nickels: " + nickels);
    }
}