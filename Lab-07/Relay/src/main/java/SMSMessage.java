public class SMSMessage extends Message {
    public SMSMessage(Recipient recipient, String text) {
        super(recipient, text);
    }
    private int segments(){
        return (text.length()+159)/160;
    }
    @Override
    public String deliver() {
        return "SMS to "+recipient.getName();
    }

    @Override
    public double cost() {
        return 0;

    }

    @Override
    public String describe() {
        return "SMS Notice";
    }
}
