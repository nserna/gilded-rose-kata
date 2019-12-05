package com.gildedrose.service;

import com.gildedrose.Item;

public class BackstageUpdater extends Updater {
    @Override
    protected int calculateQualityDelta(Item item) {
        if (hasDatePassed(item)){
            return -item.quality;
        }

        int qualityDelta = 1;

        if (item.sellIn < 10){
            qualityDelta++;
        }
        if (item.sellIn < 5){
            qualityDelta++;
        }
        return qualityDelta;
    }
}