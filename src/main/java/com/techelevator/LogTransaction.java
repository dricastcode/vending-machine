package com.techelevator;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogTransaction {
    private static final String logFileName = "Log.txt";


    public static void log(String message) {
        try (FileWriter writer = new FileWriter(logFileName, true)) {

            LocalDateTime now = LocalDateTime.now();
            String formattedDate = now.format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss"));
            writer.write(formattedDate + " | " + message + "\n");

        } catch (IOException e) {
            System.err.println("There has been an error logging this transaction: " + e.getMessage() + " SORRY!");
        }
    }
}

//    Output example:
//    11/30/1997 | 01:21:21 | Albert has deposited 5 dollars into the vendo-matic 8000 for potato crisps
//    that cost $3.05. Your change is $1.95. Thank you and enjoy the rest of your day!
