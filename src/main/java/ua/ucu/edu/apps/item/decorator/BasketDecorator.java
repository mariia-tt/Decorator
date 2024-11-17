package ua.ucu.edu.apps.item.decorator;

import ua.ucu.edu.apps.item.Item;

public class BasketDecorator extends ItemDecorator {
    private Item item;
    
    public BasketDecorator(Item item) {
        super(item);
        this.item = item;
    }
    
    @Override
    public double price() {
        return 4 + item.price();
    }
    
    @Override
    public String getDescription() {
        return item.getDescription();
    }
}
