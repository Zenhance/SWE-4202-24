public class Truck extends Vehicle {

    public Truck(String plate,String discount){
        super(plate,discount);
    }

    @Override
    public String getOwnSlotType(){
        return "LARGE";
    }

    @Override
    public String[] getAcceptedSlotTypes(){
        return new String[]{"LARGE"};
    }
}

