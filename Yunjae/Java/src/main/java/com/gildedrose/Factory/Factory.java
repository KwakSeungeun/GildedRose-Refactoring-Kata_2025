package com.gildedrose;


abstract class ItemFactory {

    final Item createOperation() {
        Item item = createItem();
        return item;
    }

    abstract protected Item createItem();
}


