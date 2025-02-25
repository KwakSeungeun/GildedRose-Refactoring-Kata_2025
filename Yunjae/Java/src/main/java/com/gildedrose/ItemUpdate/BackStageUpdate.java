package com.gildedrose.ItemUpdate;

import com.gildedrose.Item;

public class BackStageUpdate implements ItemUpdate{

    @Override
    public void update(Item item) {
        //implmentation


        item.quality++;

        if (item.sellIn <= 10) {
            item.quality++;
        }
        if (item.sellIn <= 5) {
            item.quality++;
        }
        if (item.sellIn <= 0) {
            item.quality = 0;
        }
        item.sellIn--;

        if (item.quality > 50) {
            item.quality = 50;
        }
    }
}
