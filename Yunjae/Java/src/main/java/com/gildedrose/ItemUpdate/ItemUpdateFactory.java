package com.gildedrose.ItemUpdate;

import com.gildedrose.*;

//ItemUpdateFactory는 싱글톤 패턴 적용해도 괜찮을듯
public class ItemUpdateFactory {

    public static ItemUpdate getItemUpdate(Item item) {
        switch (item.name) {
            case "Aged Brie": return new AgedBrieUpdate();
            case "Backstage passes to a TAFKAL80ETC concert": return new BackStageUpdate();
            case "Sulfuras, Hand of Ragnaros": return new SulfurasUpdate();
            default: return new DefaultUpdate();

        }
    }
}


//class ItemStrategyFactory {
//    private static final Map<String, ItemStrategy> strategies = new HashMap<>();
//
//    static {
//        strategies.put("Aged Brie", new AgedBrieStrategy());
//        strategies.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassStrategy());
//        strategies.put("Sulfuras, Hand of Ragnaros", new SulfurasStrategy());
//    }
//
//    public static ItemStrategy getStrategy(Item item) {
//        return strategies.getOrDefault(item.name, new DefaultItemStrategy());
//    }
//}

