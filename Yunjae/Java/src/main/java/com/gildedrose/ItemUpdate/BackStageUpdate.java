package com.gildedrose.ItemUpdate;

import com.gildedrose.Item;

public class BackStageUpdate implements ItemUpdate{

    @Override
    public void update(Item item) {
        //implmentation
        item.sellIn--;

        if (item.sellIn < 10) {
            item.quality += 2;
        }
        if (item.sellIn < 5) {
            item.quality++;
        }
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
