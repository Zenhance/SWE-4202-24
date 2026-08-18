public class NoPlateException extends Exception{
    public NoPlateException(){
        super("No plate found");
    }
    public NoPlateException(String message){
        super(message);
    }
}
