package com.gildedrose;

public class ItemFactory {
    //각 item type별로 별도의 기능을 수행하는 함수 저장
    private final static Map<String, BiFunction<int, int, Item>> itemMap = new HashMap<>();

    itemMap.put("Sulfuras", (sellIn, quality) -> );
    //파라메터는 createItem에 따라 그때그때
    public Item createItem(String name, int sellIn, int quality) {

    }

}
