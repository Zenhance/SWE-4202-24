public class Truck extends Vehicle {

    Truck (String number, String schemeS){
        super(number, schemeS);
    }

    Truck (String number){
        super(number);
    }

    @Override
    public int firstHourCharge (){
        return 50;
    }

    @Override
    public int furtherHourCharge (){
        return 40;
    }

    @Override
    public int Surcharge (){
        return 25;
    }
}
