package Exception;

public class NoVehicleFoundException extends Exception{
    public NoVehicleFoundException(){
        super("There is no Vehicle with that plate");
    }
    public NoVehicleFoundException(String message){
        super(message);
    }
}
