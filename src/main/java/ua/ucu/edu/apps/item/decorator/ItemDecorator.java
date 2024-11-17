package ua.ucu.edu.apps.item.decorator;

import ua.ucu.edu.apps.item.Item;

public abstract class ItemDecorator {
    private Item item;
    
    protected ItemDecorator(Item item) {
        this.item = item;
    }
    
    public String getDescription() {
        return item.getDescription();
    }
    
    public abstract double price();
}