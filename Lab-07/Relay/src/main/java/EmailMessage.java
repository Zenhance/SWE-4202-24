public class EmailMessage extends Message {
    public EmailMessage(Recipient r, String txt){
        super(r,txt);
    }
    @Override
    public String deliver() {
        String header = r.getName();
        String address = r.getAddress();
        return header + address + txt;
    }

    @Override
    public double cost() {
        return 0;
    }

    @Override
    public String describe() {
        return "EMAIL";
    }
}
