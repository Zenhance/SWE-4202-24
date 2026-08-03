package kenakata.order;

import kenakata.catalog.ColdChain;
import kenakata.catalog.Weighable;

import java.util.List;

public class DeliveryCalculator {
    public long calculate(List<OrderLine> lines, Zone zone) {
        long totalWeightGrams = 0;
        int freshLineCount = 0;

        for (OrderLine line : lines) {
            if (line.item() instanceof Weighable weighable) {
                totalWeightGrams += (long) weighable.weightGrams() * line.quantity();
            }
            if (line.item() instanceof ColdChain) {
                freshLineCount++;
            }
        }
        if (totalWeightGrams == 0 && freshLineCount == 0) {
            return 0;
        }
        long billedKg = (long) Math.ceil(totalWeightGrams / 1000.0);
        long shipping = (zone == Zone.DHAKA) ? (60 + billedKg * 20) : (120 + billedKg * 35);
        long coldChainSurcharge = freshLineCount * 50L;

        return shipping + coldChainSurcharge;
    }
}