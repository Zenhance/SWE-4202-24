public class Bike extends Vehicle{
    public Bike(String registration,String pass){
        super(registration,pass);
    }
    @Override
    public String[] getSlotPreferences(){
        return new String[]{"BIKE", "REGULAR", "LARGE"};
    }
}
