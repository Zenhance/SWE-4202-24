package kenakata.order;

import java.util.List;


public class DeliveryCalculator {
    public long deliveryCalc(Zone zone, List<OrderLine> lines){
            double weight = 0;
            int freshGoods = 0;

            for(OrderLine line : lines){
                if(line.getItem().isWeighable()){
                    weight += (((double)line.getItem().weight())/1000) *line.getUnit();
                }
                if(line.getItem().isColdchain()){
                    freshGoods++;
                }
            }

            long deliveryFee =0;
            if(weight>0){
                if(zone == Zone.DHAKA){
                    deliveryFee = (long) (Math.ceil(weight)*20 + 60);
                }
                else {
                    deliveryFee = (long) (Math.ceil(weight)*20 + 120);
                }
            }
        return deliveryFee+(freshGoods* 50L);
    }
}
