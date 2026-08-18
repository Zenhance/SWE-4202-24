package CarParking;

public final class UnknownPlateException extends ParkingException {
    public UnknownPlateException(String plate){
        super("Unknown plate:"+plate);
    }
}
