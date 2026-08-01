package kenakata.order;

import java.util.List;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.ColdChain;
import kenakata.catalog.Weighable;

public final class DeliveryCalculator {

    private static final long DHAKA_BASE = 60;
    private static final long DHAKA_PER_KG = 20;
    private static final long OUTSIDE_BASE = 120;
    private static final long OUTSIDE_PER_KG = 35;
    private static final long GRAMS_PER_KG = 1000;

    public long delivery(List<OrderLine> lines, Zone zone) {
        long totalGrams = 0;
        long coldChainTotal = 0;

        for (OrderLine line : lines) {
            if (!line.isProduct()) {
                continue;
            }
            CatalogItem item = line.product();
            if (item instanceof Weighable weighable) {
                totalGrams += weighable.unitWeightGrams() * line.quantity();
            }
            if (item instanceof ColdChain coldChain) {
                coldChainTotal += coldChain.coldChainSurcharge();
            }
        }

        if (totalGrams == 0) {
            return 0;
        }

        long billedKg = (long) Math.ceil(totalGrams / (double) GRAMS_PER_KG);
        long shipping = (zone == Zone.DHAKA)
                ? DHAKA_BASE + billedKg * DHAKA_PER_KG
                : OUTSIDE_BASE + billedKg * OUTSIDE_PER_KG;

        return shipping + coldChainTotal;
    }
}
