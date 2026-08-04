package kenakata.order;

import java.util.List;
import kenakata.catalog.Chargeable;
import kenakata.catalog.ColdChainRequired;
import kenakata.catalog.Weighable;
import kenakata.util.Money;


public final class DeliveryCalculator {

    public long calculate(List<OrderLine> lines, Zone zone) {
        long totalWeightGrams = 0;
        boolean hasWeighableLine = false;
        long coldChainSurcharge = 0;

        for (OrderLine line : lines) {
            Chargeable chargeable = line.chargeable();
            if (chargeable instanceof Weighable weighable) {
                totalWeightGrams += weighable.unitWeightGrams() * line.quantity();
                hasWeighableLine = true;
            }
            if (chargeable instanceof ColdChainRequired coldChain) {
                coldChainSurcharge += coldChain.coldChainSurcharge();
            }
        }

        if (!hasWeighableLine) {
            return 0;
        }

        long billedKg = Money.ceilDiv(totalWeightGrams, 1000);
        long shipping = zone.baseCharge() + billedKg * zone.perKgCharge();
        return shipping + coldChainSurcharge;
    }
}
