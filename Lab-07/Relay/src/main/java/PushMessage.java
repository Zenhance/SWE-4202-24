public class PushMessage extends Message{

    public PushMessage(Recipient r, String txt){
        super(r,txt);
    }
    @Override
    public String deliver() {
        return txt.substring(0, 40);
    }

    @Override
    public double cost() {
        return 50;
    }
}
