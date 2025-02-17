package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    // Aged Brie도 아니고 ticket도 아닌 경우 quality 조정 로직 (Surfuras 제외) : -1
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")
                        && !item.name.split(" ")[0].equals("Conjured")) {
                        item.quality = item.quality - 1;
                    } else if (item.name.split(" ")[0].equals("Conjured")) {
                        item.quality = item.quality - 2;
                    }
                }
                // Aged Brie 및 ticket에 대하여 부가적인 quality 조정 로직 (기본적으로 quality는 +1이며 티켓인 경우 기한에 따라서 추가적으로 +1씩 더 증가)
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }
            // sellIn에 대한 조정 로직 - Sulfuras는 제외
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }
            // sellIn이 0 미만일 때 quality 조정 로직
            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        // Age Brie가 아니고 티켓도 아닌 경우에는 0보다 크면 1씩 감소 (Sulfuras 제외)
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        // Age Brie가 아니고 티켓인 경우에는 0으로 조정
                        item.quality = 0;
                    }
                    // Aged Brie에 대한 quality는 50이 될때 까지 1씩 증가
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}
