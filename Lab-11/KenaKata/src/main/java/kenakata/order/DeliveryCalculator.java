package kenakata.order;

public class DeliveryCalculator {
    public int calculator(int weightGrams,Zone zone,int freshLines){
        if(weightGrams==0){
            return 0;
        }

        int billedKg=(int) Math.ceil(weightGrams/1000.0);
        int charge;

        if(zone== Zone.DHAKA){
            charge=60+billedKg*20;
        }
        else{
            charge=120+billedKg*35;
        }
        charge+=freshLines*50;
        return charge;
    }
}
