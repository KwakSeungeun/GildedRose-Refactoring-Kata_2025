package com.gildedrose.ItemUpdate;

import com.gildedrose.*;
import java.util.HashMap;
import java.util.Map;

public class ItemUpdateFactory {
    private static final Map<String, ItemUpdate> strategies = new HashMap<>();

    static {
        strategies.put("Aged Brie", new AgedBrieUpdate());
        strategies.put("Backstage passes to a TAFKAL80ETC concert", new BackStageUpdate());
        strategies.put("Sulfuras, Hand of Ragnaros", new SulfurasUpdate());
    }

    public static ItemUpdate getItemUpdate(Item item) {
        return strategies.getOrDefault(item.name, new DefaultUpdate());
    }
}

