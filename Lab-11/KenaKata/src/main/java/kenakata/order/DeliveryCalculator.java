package kenakata.order;

import kenakata.catalog.Chargeable;
import kenakata.catalog.Money;
import kenakata.catalog.RequiresColdChain;
import kenakata.catalog.Weighable;

import java.util.List;

public class DeliveryCalculator {

    private static final long COLD_CHAIN_SURCHARGE = 50;

    public long calculate(Zone zone, List<OrderLine> lines) {
        long totalWeightGrams = 0;
        int coldChainLineCount = 0;

        for (OrderLine line : lines) {
            Chargeable item = line.item();
            if (item instanceof Weighable weighable) {
                totalWeightGrams += weighable.weightGrams() * line.quantity();
            }
            if (item instanceof RequiresColdChain) {
                coldChainLineCount++;
            }
        }

        if (totalWeightGrams == 0) {
            return 0;
        }

        long billedKg = Money.ceilDiv(totalWeightGrams, 1000);
        return zone.baseFee() + billedKg * zone.perKgFee() + coldChainLineCount * COLD_CHAIN_SURCHARGE;
    }
}