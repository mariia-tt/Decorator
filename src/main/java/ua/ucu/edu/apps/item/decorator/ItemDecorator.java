package ua.ucu.edu.apps.item.decorator;

import ua.ucu.edu.apps.item.Item;

public abstract class ItemDecorator extends Item {
    private Item item;
    
    protected ItemDecorator(Item item) {
        this.item = item;
    }
    
    @Override
    public String getDescription() {
        return item.getDescription();
    }
    
    public Item getItem() {
        return item;
    }
}