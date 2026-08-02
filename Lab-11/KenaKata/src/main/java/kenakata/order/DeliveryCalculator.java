package kenakata.order;

import kenakata.catalog.ColdChain;
import kenakata.catalog.Weighable;

import java.util.ArrayList;

public class DeliveryCalculator {
    public long calculate(ArrayList<OrderLine> line, Zone zone ){
        long totalWeight=0;
        long coldChainCharge=0;
        long shipping=0;

        for(OrderLine lines: line){
            if(lines.product() instanceof Weighable){
                  totalWeight+= (long) lines.quantity() * ((Weighable) lines.product()).weightGrams();
            }
            if(lines.product() instanceof ColdChain){
                coldChainCharge+=50;
            }
        }

        long totalKg =(long)Math.ceil(totalWeight /1000.0);

        if(zone==Zone.DHAKA){
            shipping=60+20* totalKg ;
        }else{
            shipping=120+35* totalKg;
        }

        return shipping+coldChainCharge;


    }


}
