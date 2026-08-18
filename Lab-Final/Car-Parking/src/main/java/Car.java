public class Car extends Vehicle{
    public Car(String plate,String discount){
        super(plate,discount);
    }

    @Override
    public String getOwnSlotType(){
       return "REGULAR";
    }
    @Override
    public String[] getAcceptedSlotTypes(){
        return new String[]{"REGULAR","LARGE"};
    }
}
