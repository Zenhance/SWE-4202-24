public class PushMessage extends Message{
    private static final double PUSH_FLAT          = 0.10;  // flat push charge
    private static final int    PUSH_PREVIEW_CHARS = 40;

    public PushMessage(Recipient recipient, String body){
        super(recipient,body);
    }

    @Override
    public String getBody() {
        return super.getBody();
    }

    public String shortTxt(){
        String x=getBody();
        if(getBody().length()<=PUSH_PREVIEW_CHARS){
            return x;
        }
        else{
            return getBody().substring(0,PUSH_PREVIEW_CHARS);
        }
    }
    public String deliver(){
        return shortTxt();
    }


    public double cost() {
        return PUSH_FLAT;
    }


    public String describe() {
        return "Push note has been sent to"+getRecipient().getName();
    }


}
