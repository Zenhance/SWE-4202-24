public class PushNotice extends Notice{
    private static final double FLAT_COST = 0.25;
    private static final int PREVIEW_LENGTH = 40;
    public PushNotice(Recipient recipient, String text) {
        super(recipient, text);
    }

    @Override
    public String deliver(){
        String preview = getText();

        if(preview.length() > PREVIEW_LENGTH){
            preview = preview.substring(0,PREVIEW_LENGTH);
        }
        return "PUSH: " + preview;
    }

    @Override
    public double cost()
    {
        return FLAT_COST;
    }
    @Override
    public String describe(){
        return "Push Notice";
    }
}
