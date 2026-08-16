package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.FreshGood;
import java.util.List;

public class DeliveryCalculator {
    public long calculateDelivery(List<OrderLines> orderLines, Zone zone) {
        long total = (zone == Zone.DHAKA) ? 60 : 120;
        long perKG = (zone == Zone.DHAKA) ? 20 : 35;
        long coldSurcharge = 50;
        boolean hasShippableItem = false;

        for (OrderLines lines : orderLines) {
            if (lines.item instanceof CatalogItem catalogItem) {
                long weight = catalogItem.getWeight() * lines.quantity;

                if (weight > 0) {
                    hasShippableItem = true;
                    if (lines.item instanceof FreshGood) {
                        total += (coldSurcharge * lines.quantity) + (perKG * Math.ceil(weight / 1000.0));
                    } else {
                        total += (perKG * Math.ceil(weight / 1000.0));
                    }
                }
            }
        }

        return hasShippableItem ? total : 0;
    }
}