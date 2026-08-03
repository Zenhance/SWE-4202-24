package kenakata.order;

import java.util.List;

import kenakata.catalog.ColdChain;
import kenakata.catalog.Weighable;

public final class DeliveryCalculator {

    public long calculate(
            List<OrderLine> lines,
            Zone zone
    ) {
        if (lines == null || zone == null) {
            throw new IllegalArgumentException(
                    "Lines and zone cannot be null"
            );
        }

        long totalGrams = 0;
        long coldChainCharge = 0;

        for (OrderLine line : lines) {
            if (line == null) {
                throw new IllegalArgumentException(
                        "Lines cannot contain null"
                );
            }

            if (line.unit() instanceof Weighable weighable) {
                long lineWeight = Math.multiplyExact(
                        weighable.unitWeightGrams(),
                        line.quantity()
                );

                totalGrams = Math.addExact(
                        totalGrams,
                        lineWeight
                );
            }

            if (line.unit() instanceof ColdChain coldChain) {
                coldChainCharge = Math.addExact(
                        coldChainCharge,
                        coldChain.coldChainSurcharge()
                );
            }
        }

        if (totalGrams == 0) {
            return 0;
        }

        long billedKilograms =
                (totalGrams + 999) / 1000;

        long baseCharge;
        long chargePerKilogram;

        if (zone == Zone.DHAKA) {
            baseCharge = 60;
            chargePerKilogram = 20;
        } else {
            baseCharge = 120;
            chargePerKilogram = 35;
        }

        long weightCharge = Math.multiplyExact(
                billedKilograms,
                chargePerKilogram
        );

        return Math.addExact(
                Math.addExact(baseCharge, weightCharge),
                coldChainCharge
        );
    }

    public long deliveryFor(
            List<OrderLine> lines,
            Zone zone
    ) {
        return calculate(lines, zone);
    }
}