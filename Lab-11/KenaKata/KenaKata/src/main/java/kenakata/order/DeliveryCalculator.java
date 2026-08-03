package kenakata.order;

import java.util.List;

public final class DeliveryCalculator {
    public long calculate(List<OrderLine> lines, Zone zone) {
        if (lines == null || zone == null) {
            throw new IllegalArgumentException("Lines and zone are required");
        }
        long totalWeight = 0;
        long coldChain = 0;
        for (OrderLine line : lines) {
            if (line == null) {
                throw new IllegalArgumentException("Line cannot be null");
            }
            totalWeight = Math.addExact(totalWeight, line.totalWeightGrams());
            coldChain = Math.addExact(coldChain, line.coldChainFee());
        }
        if (totalWeight == 0) {
            return 0;
        }
        long billedKg = Math.floorDiv(Math.addExact(totalWeight, 999), 1000);
        long shipping = switch (zone) {
            case DHAKA -> Math.addExact(60, Math.multiplyExact(20, billedKg));
            case OUTSIDE -> Math.addExact(120, Math.multiplyExact(35, billedKg));
        };
        return Math.addExact(shipping, coldChain);
    }

    public long deliveryFee(List<OrderLine> lines, Zone zone) {
        return calculate(lines, zone);
    }
}
