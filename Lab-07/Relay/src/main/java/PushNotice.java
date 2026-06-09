public class PushNotice extends Notice {
    private static final int PREVIEW_LENGTH =40;
    private static final double FLAT_COST =0.10;

    public PushNotice(Recipient recipient, String text){
        super(recipient, text);
    }

    private String preview(){
        if (getText().length() <= PREVIEW_LENGTH) {
            return getText();
        }

        return getText().substring(0, PREVIEW_LENGTH);
    }

    @Override
    public String deliver(){
        return "PUSH to " + getRecipient().getName()
                + " <" + getRecipient().getAddress() + ">: "
                + preview();
    }

    @Override
    public double cost() {
        return FLAT_COST;
    }

    @Override
    public String describe() {
        return "Push notice to " + getRecipient().getName()
                + " with preview: " + preview();
    }
}