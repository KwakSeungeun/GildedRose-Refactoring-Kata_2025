package com.gildedrose.ItemUpdate;

import com.gildedrose.Item;

public class AgedBrieUpdate implements ItemUpdate{

    @Override
    public void update(Item item) {

        item.sellIn--;

        if (item.quality < 50) {
            item.quality++;
        }

    }
}
