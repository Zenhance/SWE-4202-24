public class PushMessage extends Message {
    private String name;
    private String text;
    public PushMessage(Recipient name, String text) {
        super(name, text);
    }

    @Override
    public double cost() {
        return 0.1;
    }

    @Override
    public String describe() {
        return "PUSH "+this.name;
    }

    public String deliver() {
        return text;
    }
}
