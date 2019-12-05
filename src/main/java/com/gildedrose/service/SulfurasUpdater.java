package com.gildedrose.service;

import com.gildedrose.Item;

public class SulfurasUpdater extends Updater {

    @Override
    protected void updateSellIn(Item item) {
    }

    @Override
    protected int calculateQualityDelta(Item item) {
        return 0;
    }

    @Override
    protected void restoreOutOfBoundQuality(Item item, int initQuality) {
    }
}
