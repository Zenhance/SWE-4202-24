public class PushMessage extends Notice{
    public PushMessage(Recipient r, String body){
        super(r,body);
    }

    @Override
    public String deliver() {
        String msg;
        if(body.length()>30)
            msg = body.substring(0, 31);
        else msg = body;

        return msg;
    }

    @Override
    public double cost() {
        return 0.5;
    }

    @Override
    public String describe() {
        return "it is an PUSH Message";
    }
}
