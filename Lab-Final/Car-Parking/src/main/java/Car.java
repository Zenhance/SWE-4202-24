public class Car extends Vehicle{
    public Car(String registration,String pass) {
        super(registration,pass);
    }
    @Override
    public String[] getSlotPreferences(){
        return new String[]{"REGULAR", "LARGE"};
    }
}
