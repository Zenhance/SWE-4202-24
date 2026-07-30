package kenakata.order;

import kenakata.catalog.*;

import java.util.ArrayList;


public class DeliveryCalculator {
    ArrayList<Chargeable> items;
    Zone z;

    private boolean isOnlyDigital(){
        for(Chargeable c: items){
            if(!(c instanceof DigitalGood))
                return false;
        }
        return true;
    }

    private int calculateWeightCharge(){

        int kgCharge = 0;
        if(z == Zone.DHAKA)  kgCharge = 20;
        if(z == Zone.OUTSIDE) kgCharge = 35;

        int totalW = 0;

        for(Chargeable c: items){
            if(c instanceof Weighable)
                totalW += ((Weighable) c).getWeight();
        }

        double x = Math.ceil(totalW / 1000.00) * kgCharge;
        return (int) x;
    }

    private int calculateZoneCharge(){
        int charge = 0;

        if(isOnlyDigital()) return 0;

        if(z == Zone.DHAKA)
            charge += 60;

        if(z == Zone.OUTSIDE)
            charge += 120;

        return charge;
    }

    private int coldChainPrice(){
        int chainPrice = 0;

        for(Chargeable c: items){
            if(c instanceof FreshGood)
                chainPrice += ((FreshGood) c).coldChain;
        }
        return chainPrice;
    }

    int calculateDeliveryCharge() {
        int x = calculateWeightCharge() + calculateZoneCharge() + coldChainPrice();
        return x;
    }
}
