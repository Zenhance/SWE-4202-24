package kenakata.order;

import kenakata.catalog.CatalogItem;
import java.util.List;

public class DeliveryCalculator {
    public long calculate(List<OrderLine> lines, Zone zone) {
        long weighableGrams = 0;
        long coldChain = 0;
        boolean hasWeighable = false;

        for (OrderLine line : lines) {
            if (line.unit() instanceof CatalogItem item) {
                if (item.isWeighable()) {
                    hasWeighable = true;
                    weighableGrams += (long) item.weight() * line.quantity();
                }
                if (item.isFresh()) {
                    coldChain += 50;
                }
            }
        }

        if (!hasWeighable) return 0;

        long billedKg = (long) Math.ceil(weighableGrams / 1000.0);
        long baseShipping = (zone == Zone.DHAKA) ? 60 : 120;
        long perKg = (zone == Zone.DHAKA) ? 20 : 35;

        return baseShipping + (billedKg * perKg) + coldChain;
    }
}