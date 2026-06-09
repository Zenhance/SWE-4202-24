public class SmsMessage extends Notice{

    public static final double COST_PER_SEGMENT = 0.1;
    public SmsMessage(Recipient recipient,String text) {

        super(recipient,text);
    }

    public int segment(){
        return (text.length()+159)/160;
    }
    @Override
    public String deliver() {
        return "SMS ( "+segment()+" segments ) "+text;
    }

    @Override
    public double cost() {
        return segment()*COST_PER_SEGMENT;
    }
}

