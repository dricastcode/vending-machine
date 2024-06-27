package com.techelevator;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class SalesReport {
    public static void generateReport(VendingMachine vendingMachine) {
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy_HHmm");
        String fileName = "sales_" + today.format(formatter) + ".txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            double total = 0;
            for (Map.Entry<String, Item> entry : vendingMachine.getItems().entrySet()) {
                Item item = entry.getValue();
                int quantitySold = 5 - item.getQuantity();
                double sales = quantitySold * item.getPrice();
                total += sales;
                writer.write(item.getName() + "|" + quantitySold + "\n");
            }
            writer.write("\nTotal Sales: $" + total);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
