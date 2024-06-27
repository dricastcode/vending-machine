package com.techelevator;

public class Item {
    private String slotId;
    private String name;
    private double price;
    private int quantity;
    private String type;

    public Item(String slotId, String name, double price, int quantity, String type) {
        this.slotId = slotId;
        this.name = name;
        this.price = price;
        this.quantity = 5;
        this.type = type;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSlotId() {
        return slotId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }

    public void dispense() {
        if (quantity > 0) {
            quantity--;
            System.out.println("Dispensing " + name + " for $" + price + " | " + quantity + " units left");
        } else {
            System.out.println("SOLD OUT!");
        }
    }

    private String getDispenseMessage(String type) {
        switch (type.toLowerCase()) {
            case "chip":
                return "Crunch Crunch, Yum!";
            case "candy":
                return "Munch Munch, Yum!";
            case "drink":
                return "Glug Glug, Yum!";
            case "gum":
                return "Chew Chew, Yum!";
            default:
                return "";
        }
    }
    public String getMessage() {
        return getDispenseMessage(this.type);
    }


}
