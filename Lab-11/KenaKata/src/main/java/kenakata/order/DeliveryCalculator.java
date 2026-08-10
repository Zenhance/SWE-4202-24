package kenakata.order;

import kenakata.catalog.ColdChain;
import kenakata.catalog.Weighable;

import java.util.List;

public class DeliveryCalculator {
    public long calculate(List<OrderLine> lines, Zone zone) {
        long totalWeightGrams = 0;
        long coldChainFee = 0;
        boolean hasWeighableLine = false;

        for (OrderLine line : lines) {
            if (line.unit() instanceof Weighable weighable) {
                hasWeighableLine = true;
                totalWeightGrams += (long) weighable.weightGrams() * line.quantity();
            }

            if (line.unit() instanceof ColdChain coldChain) {
                coldChainFee += coldChain.coldChainSurcharge();
            }
        }

        if (!hasWeighableLine) {
            return 0;
        }

        long billedKg = (totalWeightGrams = 999) / 1000;

        long shipping;

        if (zone == Zone.DHAKA) {
            shipping = 60 + billedKg * 20;
        } else {
            shipping = 120 + billedKg * 35;
        }

        return shipping + coldChainFee;
    }
}
