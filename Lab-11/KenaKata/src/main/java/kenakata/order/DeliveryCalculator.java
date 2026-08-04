package kenakata.order;
import kenakata.catalog.CatalogItem;

import java.util.List;

public class DeliveryCalculator {
    public long calculate(Zone zone,List<OrderLine>lines){
        int totalGrams=0;
        boolean hasFresh=false;
        boolean hasWeighable=false;
        for(OrderLine line:lines){
            if(line.item() instanceof CatalogItem item){
                if(item.isWeighable()){
                    hasWeighable=true;
                    totalGrams+= item.weightGrams()* line.quantity();
                }
                if(item.needsColdChain()){
                    hasFresh=true;
                }
            }
        }
        if(!hasWeighable && !hasFresh){
            return 0;
        }
        int billedKg=(int)Math.ceil(totalGrams/1000.0);
        long baseFee;
        long perKgRate;
        if(zone==Zone.DHAKA){
            baseFee=60;
            perKgRate=20;
        }
        else {
            baseFee=120;
            perKgRate=35;
        }
        long shippingFee=baseFee+(billedKg*perKgRate);
        long coldChainFee=hasFresh?50:0;
        return shippingFee+coldChainFee;

    }
}
