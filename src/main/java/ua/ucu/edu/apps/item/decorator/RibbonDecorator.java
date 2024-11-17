package ua.ucu.edu.apps.item.decorator;

import ua.ucu.edu.apps.item.Item;

public class RibbonDecorator extends ItemDecorator {
    private Item item;
    
    public RibbonDecorator(Item item) {
        super(item);
        this.item = item;
    }
    
    @Override
    public double price() {
        return 40 + item.price();
    }
    
    @Override
    public String getDescription() {
        return item.getDescription();
    }
}
