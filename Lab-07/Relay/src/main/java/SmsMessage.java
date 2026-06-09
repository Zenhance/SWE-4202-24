public class SmsMessage extends Message{
    public SmsMessage(Recipient r, String txt){
        super(r,txt);
    }
    @Override
    public String deliver() {
        double segments = Math.ceil(txt.length()/(double)160);
        String msg = segments +""+ txt;
        return msg;
    }

    @Override
    public double cost() {
        double segments = Math.ceil(txt.length()/(double)160);
        return (double) segments * 0.5;
    }

    @Override
    public String describe() {
        return "SMS";
    }
}
