package kenakata.order;

import kenakata.catalog.DigitalGood;
import kenakata.catalog.FreshGood;
import kenakata.catalog.StockedGood;

import java.util.List;

import static java.lang.Math.ceil;

public class DeliveryCalculator {
    private boolean feeapplies=false;
    public int Calculatedelivery(List<Line>lines,Zone zone){
        if(Zone.DHAKA==zone){
            int base=60, perkg=20,grams=0,cold=0;
            for(Line line:lines){
                if(line.item instanceof StockedGood s ) {grams+=s.getWeight()*line.quantity; feeapplies=true;}
                if(line.item instanceof FreshGood f) {grams+= f.getWeight()*line.quantity;cold=50;feeapplies=true;}
            }
            return (int) (feeapplies?((base + perkg * ceil(grams / 1000.0)) + cold) :0);

        }
        else{
            int base=120, perkg=35,grams=0,cold=0;
            for(Line line:lines){
                if(line.item instanceof StockedGood s ) grams+=s.getWeight()*line.quantity;
                if(line.item instanceof FreshGood f) {grams+= f.getWeight()*line.quantity;cold=50;}
            }
            return (int) (base+perkg*ceil(grams/1000.0))+cold;
        }
    }
}
