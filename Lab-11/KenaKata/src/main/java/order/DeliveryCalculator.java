package kenakata.order;

import java.util.List;
import kenakata.catalog.Chargeable;
import kenakata.catalog.ColdChainRequired;
import kenakata.catalog.Weighable;
import kenakata.util.Money;

/**
 * Computes the delivery fee for a set of order lines in a zone: base-plus-per-kilogram shipping
 * over the total billed weight of the weighable lines, plus a flat cold-chain surcharge for each
 * line that needs one. An order with no weighable lines at all delivers for nothing.
 */
public final class DeliveryCalculator {

    /** Total delivery charge for {@code lines} in {@code zone}. */
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
