package ua.ucu.edu.apps.item.decorator;

import ua.ucu.edu.apps.item.Item;

public class PaperDecorator extends ItemDecorator {
    private Item item;
    
    private static final double PAPER_ADDITIONAL_COST = 13.0;

    public PaperDecorator(Item item) {
        super(item);
        this.item = item;
    }

    @Override
    public double price() {
        return PAPER_ADDITIONAL_COST + item.price();
    }
    
    @Override
    public String getDescription() {
        return item.getDescription();
    }
}
