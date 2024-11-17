package ua.ucu.edu.apps.item.decorator;

import ua.ucu.edu.apps.item.Item;

public class BasketDecorator extends ItemDecorator {
    private Item item;
    
    private static final double BASKET_ADDITIONAL_COST = 4.0;

    public BasketDecorator(Item item) {
        super(item);
        this.item = item;
    }

    @Override
    public double price() {
        return BASKET_ADDITIONAL_COST + item.price();
    }

    @Override
    public String getDescription() {
        return item.getDescription();
    }
}
