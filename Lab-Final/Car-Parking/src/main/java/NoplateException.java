public class NoplateException extends Exception{
    public NoplateException(){
        super("There is no Vehicle with that plate Number");
    }
    public NoplateException(String message){
        super(message);
    }
}
