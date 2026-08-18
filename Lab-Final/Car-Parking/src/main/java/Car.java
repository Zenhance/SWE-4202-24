public class Car extends Vehicle {

    Car (String number, String schemeS){
        super(number, schemeS);
    }

    Car (String number){
        super(number);
    }

    @Override
    public int firstHourCharge (){
        return 30;
    }

    @Override
    public int furtherHourCharge (){
        return 20;
    }

    @Override
    public int Surcharge (){
        return 15;
    }
}
