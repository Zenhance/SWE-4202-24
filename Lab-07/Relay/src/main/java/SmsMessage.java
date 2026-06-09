import javax.xml.namespace.QName;

public class SmsMessage extends Message {

    private String name;
    private String text;
    private static final double COST_PER_SEGMENT = 0.05; // Example per-segment cost

    public SmsMessage(Recipient name, String text) {
        super(name, text);
    }

    public String deliver() {
        return text;
    }

    public double cost() {
        return 0.05;
    }

    public String describe() {
        String s = "Email to " + this.name;
        return s;
    }
}
