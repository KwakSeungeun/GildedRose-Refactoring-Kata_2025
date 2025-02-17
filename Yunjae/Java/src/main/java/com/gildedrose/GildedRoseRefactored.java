package com.gildedrose;

import com.gildedrose.ItemUpdate.ItemUpdateFactory;

public class GildedRoseRefactored {
    Item[] items;

    public GildedRoseRefactored(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdateFactory.getItemUpdate(item).update(item);
        }
    }
}

