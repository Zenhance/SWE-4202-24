public class NoVehivleFoundException extends Exception{
    public NoVehivleFoundException(){
        super("there's no vehicle with that plate");
    }

    public NoVehivleFoundException(String message){
        super(message);
    }
}
