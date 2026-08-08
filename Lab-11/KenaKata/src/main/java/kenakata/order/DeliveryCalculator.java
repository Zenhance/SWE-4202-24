package kenakata.order;

import kenakata.catalog.FreshGood;
import kenakata.catalog.Weighable;

import java.util.List;

public class DeliveryCalculator
{
    public long calculate(Zone zone, List<OrderLine> lines)
    {
        long totalWeight=0,freshlines=0;
        for(OrderLine line : lines)
        {
            if(line.item() instanceof Weighable weighable)
            {
                totalWeight=totalWeight+weighable.weightGrams()+line.qty();
            }
            if(line.item() instanceof FreshGood)
            {
                freshlines++;
            }
        }
        if(totalWeight==0)return 0;
        long billedWeightInKG=(long)Math.ceil(totalWeight/1000);

        long shipping;
        if(zone==Zone.DHAKA)shipping=60+billedWeightInKG*20;
        else shipping=120+billedWeightInKG*35;

        long coldChain=freshlines*50;
        return shipping+coldChain;
    }
}
