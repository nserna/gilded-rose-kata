package com.gildedrose.service;

import com.gildedrose.Item;

public class ConjuredUpdater extends NormalUpdater {
    @Override
    protected int calculateQualityDelta(Item item) {
        return 2 * super.calculateQualityDelta(item);
    }
}
