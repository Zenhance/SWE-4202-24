package kenakata.order;

import java.util.List;

import kenakata.catalog.CatalogItem;

public class DeliveryCalculator {

    public long delivery(List<OrderLine> lines, Zone zone) {
        long grams = 0;
        int freshLines = 0;
        for (OrderLine line : lines) {
            if (!line.isProduct())
                continue;
            CatalogItem item = line.product();
            if (item.weightGrams() > 0) {
                grams += (long) item.weightGrams() * line.quantity();
                if (item.isColdChain()) freshLines++;
            }
        }

        if (grams == 0) return 0;
        long billedKg = (long) Math.ceil(grams / 1000.0);
        long shipping;
        if (zone == Zone.DHAKA) {
            shipping = 60 + billedKg * 20;
        } else {
            shipping = 120 + billedKg * 35;
        }
        long coldChain = freshLines * 50L;
        return shipping + coldChain;
    }
}