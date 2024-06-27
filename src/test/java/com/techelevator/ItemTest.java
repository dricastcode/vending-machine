package com.techelevator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

    @Test
    public void testItemCreation() {
        Item item = new Item("A1", "Potato Crisps", 3.05, 5, "Chip");
        assertEquals("Potato Crisps", item.getName());
        assertEquals(3.05, item.getPrice());
        assertEquals("A1", item.getSlotId());
        assertEquals("Chip", item.getType());
    }

}

