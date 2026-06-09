public class SmsMessage extends Message {

    public static final double COST_PER_SEGMENT = 0.5;
    public SmsMessage(Recipient recipient,String text) {
        super(recipient,text);
    }

    public double segment(){
        return Math.ceil((double) text.length() /160);
    }
    @Override
    public String deliver() {
        return "SMS ( "+segment()+" segments ) "+text;
    }

    @Override
    public double cost() {
        return segment()*COST_PER_SEGMENT;

    }

    @Override
    public String describe() {
        return "SMS";
    }
}

