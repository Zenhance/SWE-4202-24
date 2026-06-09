public class PushMessage extends Message {
    public PushMessage(Recipient recipient, String text) {
        super(recipient, text);
    }
@Override
public String deliver(){
        String preview;
        if(text.length()<=40){
            preview=text;
        }
        else{
            preview=text.substring(0,40);
        }
        return "PUSH: "+preview;
}
    @Override
    public double cost() {
        return 0.25;
    }
    @Override
    public String describe(){
        return "Push Notice";
    }

}
