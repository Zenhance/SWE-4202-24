package kenakata.order;

import kenakata.catalog.Chargeable;
import kenakata.catalog.ColdChainable;
import kenakata.catalog.Weighable;

import java.util.List;


public class DeliveryCalculator {
    public long calculate(List<Chargeable> lines,Zone zone){
        int totalWeight = 0;
        int freshCount = 0;

        for(Chargeable line : lines){
            if(line instanceof Weighable weighable){
                totalWeight += weighable.weight();
            }
            if(line instanceof ColdChainable cold){
                if(cold.needsColdChain()){
                    freshCount++;
                }

            }

        }

        if(totalWeight == 0){
            return 0;
        }


        int billedKg =
                (totalWeight + 999) / 1000;


        long shipping;


        if(zone == Zone.DHAKA){
            shipping = 60 + (billedKg * 20);
        }
        else {
            shipping = 120 + (billedKg * 35);
        }

        long coldChain = freshCount * 50;
        return shipping + coldChain;

    }

}