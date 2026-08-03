package kenakata.order;

import java.util.List;
import kenakata.catalog.ColdChain;
import kenakata.catalog.Weighable;

public final class DeliveryCalculator {
    public long calculate(List<OrderLine> lines,Zone zone){
        if(lines == null || zone == null){
            throw new IllegalArgumentException("Lines and zone must not be null");
        }
        long totalGrams = 0;
        long coldChain = 0;
        boolean hasWeighableLine = false;

        for(OrderLine line : lines){
            if(line.unit() instanceof Weighable weighable){
                hasWeighableLine = true;
                long lineWeight = Math.multiplyExact((long) weighable.unitWeightGrams(),line.quantity());
                totalGrams = Math.addExact(totalGrams,lineWeight);
            }
            if(line.unit() instanceof ColdChain chilled){
                coldChain = Math.addExact(coldChain,chilled.coldChainSurcharge());
            }
        }
        if(!hasWeighableLine){
            return 0;
        }
        long billedKg = totalGrams/1000 + (totalGrams%1000 == 0?0:1);
        long base;
        long perKg;
        if(zone==Zone.DHAKA){
            base = 60;
            perKg = 20;
        } else {
            base = 120;
            perKg = 35;
        }
        long weightCharge = Math.multiplyExact(billedKg,perKg);
        return Math.addExact(Math.addExact(base,weightCharge),coldChain);
    }
    public long deliveryFor(List<OrderLine> lines, Zone zone){
        return calculate(lines,zone);
    }
}
