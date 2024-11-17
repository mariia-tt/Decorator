package ua.ucu.edu.apps.item.decorator;

import ua.ucu.edu.apps.item.Item;

public class RibbonDecorator extends ItemDecorator {
    private static final double RIBBON_ADDITIONAL_COST = 40.0;
    
    public RibbonDecorator(Item item) {
        super(item);
    }

    @Override
    public double price() {
        return RIBBON_ADDITIONAL_COST + getItem().price();
    }
}