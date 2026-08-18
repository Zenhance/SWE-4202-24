public class NoNumberPlateException extends Exception{
    public NoNumberPlateException(){
        super("there's no number plate");
    }

    public NoNumberPlateException(String message){
        super(message);
    }
}
