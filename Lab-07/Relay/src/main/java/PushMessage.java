public class PushMessage extends Message{
    private static final double PUSH_FLAT          = 0.10;  // flat push charge
    private static final int    PUSH_PREVIEW_CHARS = 40;

    public PushMessage(Recipient recipient, String body){
        super(recipient,body);
    }


    public String deliver() {
        return "";
    }


    public double cost() {
        return 0;
    }


    public String describe() {
        return "";
    }

}
