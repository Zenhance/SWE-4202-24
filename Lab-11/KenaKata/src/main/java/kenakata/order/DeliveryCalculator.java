package kenakata.order;

import java.util.List;

public class DeliveryCalculator {
    public long calculateDelivery(List<OrderLine> lines, Zone zone){}
    int totalWeightGrams= 0;
    long coldChainFee = 0;
    boolean hasWeighable= false;

    for(OrderLine line: lines){
        Chargeable item = line.item();
        if(item instanceof Weighable weighable){
            totalWeightGrams += weighable.weightGrams() * line.quantity();
            hasWeighable= true;
        }
        if(item instanceof ColdChain coldChain){
            coldChainFee+=coldChainFee.coldChainSurcharge();
        }
    }
    if(!hasWeighable){
        return 0;
    }
    int billedKg= (int) Math.ceil(totalWeightGrams/1000.0);
    long baseShipping;
}
