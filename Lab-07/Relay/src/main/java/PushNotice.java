import com.sun.jdi.event.StepEvent;

public class PushNotice extends Notice {
    public PushNotice(Recipient recipient, String text) {
        super(recipient, text);
    }
    @Override
    public String deliver() {
        if (text.length() <= 40) {
            return text;
        } else {
            return text.substring(0, 40);
        }
    }
    @Override
     public double cost(){
            return 0.50;
        }
     @Override
     public String describe(){
            return "Push Notice";
        }


}
