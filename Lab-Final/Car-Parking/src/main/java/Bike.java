public class Bike extends Vehicle{
    public Bike(String plate,String discount){
        super(plate,discount);
    }

    @Override
    public String getOwnSlotTYpe(){
        return "BIKE";
    }

    @Override
    public String[] getAcceptedSlotTypes() {
        return new String[]{
                "BIKE", "REGULAR", "LARGE"
        };
    }
}
