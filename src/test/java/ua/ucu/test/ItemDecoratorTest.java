package ua.ucu.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.ucu.edu.apps.item.Item;
import ua.ucu.edu.apps.item.decorator.BasketDecorator;
import ua.ucu.edu.apps.item.decorator.PaperDecorator;
import ua.ucu.edu.apps.item.decorator.RibbonDecorator;
import org.junit.jupiter.api.Assertions;

public class ItemDecoratorTest {
    private static final double BASE_PRICE = 10.0;
    private static final double BASKET_COST = 4.0;
    private static final double PAPER_COST = 13.0;
    private static final double RIBBON_COST = 40.0;
    private static final double ZERO_BASE_PRICE = 0.0;
    private static final String BASE_DESCRIPTION = "Test Item";
    private static final String ZERO_PRICE_DESCRIPTION = "Zero Price Item";

    private Item baseItem;

    private static class TestItem extends Item {
        private final double basePrice;
        private final String description;

        public TestItem(double basePrice, String description) {
            this.basePrice = basePrice;
            this.description = description;
        }

        @Override
        public double price() {
            return basePrice;
        }

        @Override
        public String getDescription() {
            return description;
        }
    }

    @BeforeEach
    void setUp() {
        baseItem = new TestItem(BASE_PRICE, BASE_DESCRIPTION);
    }

    @Test
    void testBasicDecorators() {
        Item basketDecorator = new BasketDecorator(baseItem);
        Assertions.assertEquals(BASE_PRICE + BASKET_COST, basketDecorator
        .price());
        Assertions.assertEquals(BASE_DESCRIPTION, basketDecorator
        .getDescription());

        Item paperDecorator = new PaperDecorator(baseItem);
        Assertions.assertEquals(BASE_PRICE + PAPER_COST, paperDecorator
        .price());
        Assertions.assertEquals(BASE_DESCRIPTION, paperDecorator
        .getDescription());

        Item ribbonDecorator = new RibbonDecorator(baseItem);
        Assertions.assertEquals(BASE_PRICE + RIBBON_COST, ribbonDecorator
        .price());
        Assertions.assertEquals(BASE_DESCRIPTION, ribbonDecorator
        .getDescription());
    }

    @Test
    void testZeroPriceItem() {
        Item zeroItem = new TestItem(ZERO_BASE_PRICE,
         ZERO_PRICE_DESCRIPTION);
        Assertions.assertEquals(BASKET_COST, new BasketDecorator(zeroItem)
        .price());
        Assertions.assertEquals(PAPER_COST, new PaperDecorator(zeroItem)
        .price());
        Assertions.assertEquals(RIBBON_COST, new RibbonDecorator(zeroItem)
        .price());
    }

    @Test
    void testCombinedDecorators() {
        Item basketDecorated = new BasketDecorator(baseItem);
        Item paperDecorated = new PaperDecorator(basketDecorated);
        Item ribbonDecorated = new RibbonDecorator(paperDecorated);

        double expectedPrice = BASE_PRICE + BASKET_COST + PAPER_COST
         + RIBBON_COST;
        Assertions.assertEquals(expectedPrice, ribbonDecorated.price());
        Assertions.assertEquals(BASE_DESCRIPTION, ribbonDecorated
        .getDescription());
    }
}
