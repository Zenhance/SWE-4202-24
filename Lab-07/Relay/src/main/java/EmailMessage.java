public class EmailMessage extends Notice {
    public EmailMessage(Recipient r, String txt){
        super(r,txt);
    }
    @Override
    public String deliver() {
        return "";
    }

    @Override
    public double cost() {
        return 0;
    }
}
