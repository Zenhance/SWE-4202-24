public class NoVehicleFoundException extends Exception{
    public NoVehicleFoundException(){
        super("No Vehicle Found");
    }
    public NoVehicleFoundException(String message){
        super(message);
    }
}
