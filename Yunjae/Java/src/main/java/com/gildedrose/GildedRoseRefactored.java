package com.gildedrose;

public class GildedRoseRefactored {
}

package com.gildedrose;

// Step 1: Create Strategy Interface
interface ItemStrategy {
    void update(Item item);
}

// Step 2: Implement Strategies
class AgedBrieStrategy implements ItemStrategy {
    @Override
    public void update(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
        item.sellIn--;
        if (item.sellIn < 0 && item.quality < 50) {
            item.quality++;
        }
    }
}

class BackstagePassStrategy implements ItemStrategy {
    @Override
    public void update(Item item) {
        if (item.quality < 50) {
            item.quality++;
            if (item.sellIn < 11) item.quality++;
            if (item.sellIn < 6) item.quality++;
        }
        item.sellIn--;
        if (item.sellIn < 0) item.quality = 0;
    }
}

class SulfurasStrategy implements ItemStrategy {
    @Override
    public void update(Item item) {
        // Legendary item does not change
    }
}

class DefaultItemStrategy implements ItemStrategy {
    @Override
    public void update(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
        item.sellIn--;
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality--;
        }
    }
}

// Step 3: Factory to Get Correct Strategy
class ItemStrategyFactory {
    public static ItemStrategy getStrategy(Item item) {
        switch (item.name) {
            case "Aged Brie": return new AgedBrieStrategy();
            case "Backstage passes to a TAFKAL80ETC concert": return new BackstagePassStrategy();
            case "Sulfuras, Hand of Ragnaros": return new SulfurasStrategy();
            default: return new DefaultItemStrategy();
        }
    }
}

// Step 3: Factory to Get Correct Strategy Using Map
class ItemStrategyFactory {
    private static final Map<String, ItemStrategy> strategies = new HashMap<>();

    static {
        strategies.put("Aged Brie", new AgedBrieStrategy());
        strategies.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassStrategy());
        strategies.put("Sulfuras, Hand of Ragnaros", new SulfurasStrategy());
    }

    public static ItemStrategy getStrategy(Item item) {
        return strategies.getOrDefault(item.name, new DefaultItemStrategy());
    }
}


// Step 4: Modify GildedRose to Use Strategies
class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemStrategyFactory.getStrategy(item).update(item);
        }
    }
}
