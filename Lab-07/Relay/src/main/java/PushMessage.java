public class PushMessage extends Message {
    private static final int PREVIEW_SIZE=40;
    private static final double FLAT_COST=1.00;

    public PushMessage(Recipient recipient, String text){
        super(recipient,text);
    }
  private String preview(){
        if(getText().length()<=PREVIEW_SIZE){
            return getText();
        }
        return getText().substring(0,PREVIEW_SIZE);
  }
    @Override
    public String deliver() {
        return "PUSH message to "+getRecipient().getName()+": "+preview();
    }

    @Override
    public double cost() {
        return 0.25;
    }

    @Override
    public String describe() {
        return "PUSH notice to "+getRecipient().getName();
    }


}
