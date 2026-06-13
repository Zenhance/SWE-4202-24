import javax.xml.namespace.QName;

public class SmsMessage extends Message {

    private static final double COST_PER_SEGMENT = 0.5;

    public SmsMessage(Recipient name, String text) {
        super(name, text);
    }

    public String deliver() {
        return text;
    }

    public double cost() {
        int count;
        if (text.length()%160 == 0)
        {
            count=text.length()/160;
        }
        else
        {
            count=text.length()/160+1;
        }
        return 0.5*count;
    }

    public String describe() {
        return  "SMS" ;
    }
}
