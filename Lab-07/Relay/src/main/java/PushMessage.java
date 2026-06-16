public class PushMessage extends Message {
    private static final int PREVIEW_LENGTH = 40;

    public PushMessage(Recipient r, String body) {
        super(r, body);
    }

    @Override
    public String deliver() {
        if (body.length() <= PREVIEW_LENGTH) {
            return body;
        }
        return body.substring(0, PREVIEW_LENGTH) + "...";
    }

    @Override
    public double cost() {
        return 0.10;
    }
    @Override
    public String describe() {
        return "PUSH notice for " + recipient.getName();
    }
}