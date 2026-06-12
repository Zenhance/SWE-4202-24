public class PushMessage extends Message {
    private static final double PUSH_FLAT          = 0.10;
    private static final int    PUSH_PREVIEW_CHARS = 40;

    public PushMessage (Recipient recipient, String body) {
        super(recipient, body);
    }

    public String preview() {
        String x = getBody();
        if(x.length() <= PUSH_PREVIEW_CHARS) return x;
        return (x.substring(0, PUSH_PREVIEW_CHARS));
    }

    public String deliver() {
        return ("PUSH: " + preview());
    }

    public double cost() {
        return PUSH_FLAT;
    }

    public String describe() {
        return ("Push to :" + getRecipient().getName() + getRecipient().getAddress());
    }

}
