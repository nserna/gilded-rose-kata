package com.gildedrose;


import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TexttestFixture {
    private static final String NEW_LINE = System.getProperty("line.separator");

    @Test
    public void textTest() {
        String[] args =  {"20"};
        StringBuilder text = new StringBuilder("OMGHAI!" + NEW_LINE);

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            text.append("-------- day " + i + " --------" + NEW_LINE);
            text.append("name, sellIn, quality" + NEW_LINE);
            for (Item item : items) {
                text.append(item + NEW_LINE);
            }
            text.append(NEW_LINE);
            app.updateQuality();
        }
        assertEquals(text.toString().trim(), readFile("20days.txt"));
    }

    private String readFile(String filePath)
    {
        return read(filePath).lines().collect(Collectors.joining(NEW_LINE));
    }

    private BufferedReader read(String path) {
        return new BufferedReader(new InputStreamReader((this.getClass().getResourceAsStream("/" + path))));
    }

}