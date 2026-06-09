public class PushMessage extends Notice {
    public PushMessage(Recipient r,String msg){
        super(r,msg);
    }

    @Override
    public String deliver() {
        return msg.substring(0,40);
    }

    @Override
    public double cost() {
        return 2;
    }
}
