package CarParking;

public final class NoPlateException extends ParkingException{
        public NoPlateException(){
            super("No plate");
    }
}
