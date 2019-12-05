package com.gildedrose.service;

import com.gildedrose.Item;

public class AgedBrieUpdater extends Updater {
    private static final int AUGMENTATION_AFTER_EXPIRATION = 2;
    private static final int AUGMENTATION_BEFORE_EXPIRATION = 1;

    @Override
    protected int calculateQualityDelta(Item item) {
        return (hasDatePassed(item))?AUGMENTATION_AFTER_EXPIRATION: AUGMENTATION_BEFORE_EXPIRATION;
    }
}
