public class SmsMessage extends Message{

    public SmsMessage(Recipient recipient, String body) {
        super(recipient, body);
    }

    @Override
    public double cost() {
        int segment;
        if (body.length()%160 == 0) {
            segment = body.length()/160;
        }
        else {
            segment = body.length()/160+1;
        }
        return 0.5*segment;
    }

    @Override
    public String deliver() {
        return body;
    }

    @Override
    public String describe() {
        return "SMS";
    }
}