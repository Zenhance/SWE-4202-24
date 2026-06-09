public class PushNotice extends Notice{
    private static final double PUSH_FLAT          = 0.10;
    private static final int    PUSH_PREVIEW_CHARS = 40;

    public PushNotice(Recipient recipient,String text){
        super(recipient,text);
    }

    private String preview(){
        if(getText().length()<= PUSH_PREVIEW_CHARS){return getText();}
    }
}
