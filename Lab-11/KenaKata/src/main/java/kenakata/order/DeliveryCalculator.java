package kenakata.order;

import kenakata.catalog.CatalogItem;
import kenakata.catalog.ColdChain;
import kenakata.catalog.Weighable;

import java.util.List;

public class DeliveryCalculator {
    
    public long calculate(List<OrderLine> lines, Zone zone) {
        
        long totalWeightGrams = 0;
        long coldChainCharge = 0;
        
        for (OrderLine line : lines) {
            
            CatalogItem product = line.getProduct();
            
            if (product == null)
                continue;
            
            if (product instanceof Weighable weighable) {
                totalWeightGrams += (long) weighable.getWeight() * line.getQuantity();
            }
            
            if (product instanceof ColdChain coldChain) {
                coldChainCharge += coldChain.coldChainSurcharge();
            }
        }
        
        if (totalWeightGrams == 0)
            return 0;
        
        long billedKg = (long) Math.ceil(totalWeightGrams / 1000.0);
        
        long delivery = switch (zone) {
            case DHAKA -> 60 + billedKg * 20;
            case OUTSIDE -> 120 + billedKg * 35;
        };
        
        return delivery + coldChainCharge;
    }
}