package kenakata.order;

import kenakata.catalog.ColdChain;
import kenakata.catalog.Weighable;

import java.util.List;

public final class DeliveryCalculator {

    private static final long DHAKA_BASE = 60;
    private static final long DHAKA_PER_KG = 20;
    private static final long OUTSIDE_BASE = 120;
    private static final long OUTSIDE_PER_KG = 35;

    public long calculate(Zone zone, List<OrderLine> lines) {
        long totalWeightGrams = 0;
        long coldChainTotal = 0;
        boolean hasWeighable = false;

        for (OrderLine line : lines) {
            Object content = line.content();
            if (content instanceof Weighable weighable) {
                hasWeighable = true;
                totalWeightGrams += weighable.unitWeightGrams() * line.quantity();
            }
            if (content instanceof ColdChain coldChain) {
                coldChainTotal += coldChain.coldChainSurcharge();
            }
        }

        if (!hasWeighable) {
            return 0;
        }

        long billedKg = (totalWeightGrams + 999) / 1000; // round up to the next whole kg
        long base = zone == Zone.DHAKA ? DHAKA_BASE : OUTSIDE_BASE;
        long perKg = zone == Zone.DHAKA ? DHAKA_PER_KG : OUTSIDE_PER_KG;

        return base + perKg * billedKg + coldChainTotal;
    }
}
