public class EmailMessage extends Message {
    public EmailMessage(Recipient r, String txt){
        super(r,txt);
    }
    @Override
    public String deliver() {
        String header = r.getName();
        return header + txt;
    }

    @Override
    public double cost() {
        return 0;
    }
}
