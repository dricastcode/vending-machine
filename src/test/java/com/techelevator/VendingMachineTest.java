package com.techelevator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class VendingMachineTest {
    private VendingMachine vendingMachine;

    @BeforeEach
    public void setup() {
        vendingMachine = new VendingMachine();
    }

    @Test
    public void testItemsFromCSV() {
        assertFalse(vendingMachine.getItems().isEmpty());
    }

    @Test
    public void testFeedMoney() {
        vendingMachine.feedMoney(5.00);
        assertEquals(5.00, vendingMachine.getCurrentMoney());
    }

    @Test
    public void testSelectItem() {
        vendingMachine.feedMoney(5.00);
        vendingMachine.selectItem("A1");
        assertEquals(1.95, vendingMachine.getCurrentMoney(), 0.01);
    }

    @Test
    public void testFinishTransaction() {
        vendingMachine.feedMoney(5.00);
        vendingMachine.endTransaction();
        assertEquals(0, vendingMachine.getCurrentMoney());
    }

}





