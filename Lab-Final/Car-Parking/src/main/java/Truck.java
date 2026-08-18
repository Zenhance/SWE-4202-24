public class Truck extends Vehicle{
    public Truck(String registration,String pass) {
        super(registration,pass);
    }
    @Override
    public String[] getSlotPreferences(){
        return new String[]{"LARGE"};
    }
}
