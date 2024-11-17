package ua.ucu.edu.apps.item.decorator;

import ua.ucu.edu.apps.item.Item;

public class PaperDecorator extends ItemDecorator {
    private Item item;
    
    public PaperDecorator(Item item) {
        super(item);
        this.item = item;
    }
    
    @Override
    public double price() {
        return 13 + item.price();
    }
    
    @Override
    public String getDescription() {
        return item.getDescription();
    }
}
