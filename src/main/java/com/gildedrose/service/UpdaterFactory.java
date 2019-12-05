package com.gildedrose.service;

import com.gildedrose.Item;
import com.gildedrose.util.DefaultHashMap;

import java.util.Map;

public class UpdaterFactory {
    private static Map<String, Updater> updaterMap = new DefaultHashMap<>(new NormalUpdater());
    static {
        updaterMap.put("Aged Brie", new AgedBrieUpdater());
        updaterMap.put("Backstage passes to a TAFKAL80ETC concert", new BackstageUpdater());
        updaterMap.put("Sulfuras, Hand of Ragnaros", new SulfurasUpdater());
        updaterMap.put("Conjured Mana Cake", new ConjuredUpdater());
    }

    public static void update(Item item){
        updaterMap.get(item.name).update(item);
    }
}