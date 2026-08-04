package kenakata.order;

import kenakata.catalog.FreshGood;
import kenakata.catalog.StockedGood;

public class DeliveryCalculator {
    public long calculate(Order order) {
        long weightGrams = 0;
        long coldChain = 0;

        for(OrderLine line : order.lines()) {
            if(line.item instanceof StockedGood sg)
                weightGrams += sg.weightGrams() * line.qty;
            if(line.item instanceof FreshGood fg) {
                weightGrams += fg.weightGrams() * line.qty;
                coldChain += 50;
            }
        }

        long billedKg = (long)Math.ceil(weightGrams/1000.0);
        if(billedKg == 0)
            return 0;

        if(order.zone() == Zone.DHAKA) {
            return 60 + billedKg * 20 + coldChain;
        } else {
            return 120 + billedKg * 35 + coldChain;
        }
    }
}
