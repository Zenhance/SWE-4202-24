package kenakata.order;
import kenakata.catalog.ColdChain;
import kenakata.catalog.Weighable;
import java.util.List;

public class DeliveryCalculator {
    public long calculate(List<OrderLine> lines,Zone zone){
        long totalWeightGrams=0;
        long coldChainFee=0;
        boolean hasWeighable= false;
      for(OrderLine line:lines){
          if(line.getItem() instanceof Weighable w){
              totalWeightGrams+=w.weightGrams()*line.getQuantity();
              hasWeighable=true;
          }
          if(line.getItem() instanceof ColdChain){
              coldChainFee+=50;
          }
      }
      if(!hasWeighable){
          return 0;
      }
      long billedKg=(long) Math.ceil(totalWeightGrams/1000.0);
      long shipping=(zone==Zone.DHAKA)?(60+billedKg*20):(120+billedKg*35);
      return shipping+coldChainFee;
    }
}
