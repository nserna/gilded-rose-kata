package com.gildedrose.service;

import com.gildedrose.Item;

public class NormalUpdater extends Updater {
    public static final int DEGRADATION_BEFORE_EXPIRATION = -1;
    public static final int DEGRADATION_AFTER_EXPIRATION = -2;

    @Override
    protected int calculateQualityDelta(Item item) {
        return (hasDatePassed(item))?DEGRADATION_AFTER_EXPIRATION: DEGRADATION_BEFORE_EXPIRATION;
    }
}
