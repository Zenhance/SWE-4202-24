public class Bike extends Vehicle{

    Bike(String number, String schemeS){
        super(number, schemeS);
    }

    Bike(String number){
        super(number);
    }

    @Override
    public int firstHourCharge (){
        return 10;
    }

    @Override
    public int furtherHourCharge (){
        return 5;
    }

    @Override
    public int Surcharge (){
        return 0;
    }
}
