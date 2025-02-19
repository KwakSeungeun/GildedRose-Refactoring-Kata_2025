package com.gildedrose.ItemUpdate;

import com.gildedrose.Item;

public class DefaultUpdate implements ItemUpdate{

    @Override
    public void update(Item item) {

        item.sellIn--;
        if (item.quality > 0) {
            item.quality--;
            if (item.sellIn < 0) {
                item.quality--;
            }
        }
    }
}
