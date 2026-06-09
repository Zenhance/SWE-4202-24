public class PushNotice extends Notice{
    public PushNotice(Recipient recipient, String text) {
        super(recipient, text);
    }
@Override
public String deliver(){
        String preview;
        if(text.length()<=40){
            preview=text;
        }
}
    @Override
    public double cost() {
        return 0;
    }

}
