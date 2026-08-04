package kenakata.order;
import kenakata.catalog.Chargeable;
import kenakata.catalog.FreshGood;
import kenakata.catalog.Weightable;

import java.util.ArrayList;
import java.util.List;

public class DeliveryCalculator {
    public long calculate(ArrayList<Chargeable> items,ArrayList<Integer> quantities,Zone zone){
        int totalWeight=0,freshLines=0;

        for(int i=0;i<items.size();i++){
            Chargeable item=items.get(i);
            int quantity=quantities.get(i);
            if(item instanceof Weightable weightable){
                totalWeight+=weightable.weight()*quantity;
            }
            if(item instanceof FreshGood){
                freshLines++;
            }
        }
        if(totalWeight==0)return 0;
        long billedWeightInKG=(long)Math.ceil(totalWeight/1000);

        long shipping;
        if(zone==Zone.DHAKA)shipping=60+billedWeightInKG*20;
        else shipping=120+billedWeightInKG*35;

        long coldChain=freshLines*50;
        return shipping+coldChain;
    }
}
