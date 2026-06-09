public class PushMessage extends Message{

    public PushMessage(Recipient r, String txt){
        super(r,txt);
    }
    @Override
    public String deliver() {
        String res = "";
        if (txt.length() >= 40)
        res = txt.substring(0,40);
        else res = txt.substring(0);

        return res;
    }

    @Override
    public double cost() {
        return 0.1;
    }

    @Override
    public String describe() {
        return "PUSH";
    }
}
