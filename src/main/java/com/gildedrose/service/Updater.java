package com.gildedrose.service;

import com.gildedrose.Item;

public abstract class Updater{
    public static final int MIN_QUALITY = 0;
    public static final int MAX_QUALITY = 50;

    public void update(Item item){
        int initQuality = item.quality;
        updateSellIn(item);
        updateQuality(item);
        restoreOutOfBoundQuality(item, initQuality);
    }

    protected void restoreOutOfBoundQuality(Item item, int initQuality) {
        //This does not keep the legacy way of working
        //item.quality = Math.min(Math.max(item.quality, MIN_QUALITY), MAX_QUALITY);

        if ((item.quality < MIN_QUALITY) && (initQuality > item.quality)){
            item.quality = Math.min(initQuality, MIN_QUALITY);
        } else if ((item.quality > MAX_QUALITY) && (initQuality < item.quality)){
            item.quality = Math.max(initQuality, MAX_QUALITY);
        }
    }

    protected void updateSellIn(Item item) {
        item.sellIn--;
    }

    private void updateQuality(Item item) {
        item.quality += calculateQualityDelta(item);
    }

    protected abstract int calculateQualityDelta(Item item);

    protected boolean hasDatePassed(Item item) {
        return item.sellIn < 0;
    }
}
