public class PushMessage extends Message{
    public PushMessage(Recipient recipient, String body) {
        super(recipient, body);
    }

    @Override
    public double cost() {
        return 0.25;
    }

    @Override
    public String deliver() {
        return body;
    }

    @Override
    public String describe() {
        return "PUSH";
    }
}
