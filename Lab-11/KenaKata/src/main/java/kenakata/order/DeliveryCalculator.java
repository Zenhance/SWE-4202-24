package kenakata.order;

import java.util.List;

public class DeliveryCalculator { //for computing the exact shipping cost for an order
    public long calculateDelivery(List<OrderLine> lines, Zone zone) {
        int totalWeightGrams = 0;
        long coldChainFee = 0;
        boolean hasWeighable = false;

        for (OrderLine line : lines) {
            Chargeable item = line.item();
            if (item instanceof Weighable weighable) { //identify physical goods
                totalWeightGrams += weighable.weightGrams() * line.quantity();
                hasWeighable = true;
            }
            if (item instanceof ColdChain coldChain) { //for fresh goods
                coldChainFee += coldChain.coldChainSurcharge();
            }
        }
        if (!hasWeighable) { //if only digital goods
            return 0;
        }
        int billedKg = (int) Math.ceil(totalWeightGrams / 1000.0);
        long baseShipping;

        if (zone == Zone.DHAKA) {
            baseShipping = 60 + (billedKg * 20L);// 60base fee and 20 tk per billed kg
        } else {
            baseShipping = 120 + (billedKg * 35L);
        }
        return baseShipping + coldChainFee;
    }
}
