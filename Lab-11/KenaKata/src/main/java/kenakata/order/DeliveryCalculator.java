package kenakata.order;
import kenakata.catalog.FreshGood;
import kenakata.catalog.Weightable;

import java.util.List;

public class DeliveryCalculator {

    public long calculate(List<OrderLine>lines,Zone zone){
        int totalWeight=0,freshLines=0;

        for(OrderLine line:lines){
            if(line.item() instanceof Weightable weightable){
                totalWeight+=weightable.weight()*line.quantity();
            }
            if(line.item() instanceof FreshGood){
                freshLines++;
            }
        }
        if(totalWeight==0)return 0;
        long billedWeight=(long)Math.ceil(totalWeight/1000);

    }
}
