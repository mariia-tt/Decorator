package ua.ucu.edu.apps.item.decorator;

import ua.ucu.edu.apps.item.Item;

public class RibbonDecorator extends ItemDecorator {
    private static final double RIBBON_ADDITIONAL_COST = 40.0;

    private Item item;

    public RibbonDecorator(Item item) {
        super(item);
        this.item = item;
    }

    @Override
    public double price() {
        return RIBBON_ADDITIONAL_COST + item.price();
    }

    @Override
    public String getDescription() {
        return item.getDescription();
    }
}
