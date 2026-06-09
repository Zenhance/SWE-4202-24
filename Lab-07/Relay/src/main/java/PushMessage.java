public class PushMessage extends Notice{
    private static final double PUSH_FLAT          = 0.10;
    private static final int    PUSH_PREVIEW_CHARS = 40;

    public PushMessage(Recipient recipient, String text){
        super(recipient,text);
    }

    private String preview(){
        if(getText().length()<= PUSH_PREVIEW_CHARS){return getText();}
        return getText().substring(0,PUSH_PREVIEW_CHARS);
    }

    @Override
    public String deliver(){
        return "PUSH to "+getRecipient().getName()+": "+preview();
    }
    @Override
    public double cost(){
        return PUSH_FLAT;
    }

}
