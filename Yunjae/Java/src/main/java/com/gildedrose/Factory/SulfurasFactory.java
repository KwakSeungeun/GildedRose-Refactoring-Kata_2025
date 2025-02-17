package com.gildedrose;

public class SulfurasFactory extends ItemFactory {

    @Override
    public Item createItem() {
        return new Sulfuras("s", 1, 1);
    }
}


