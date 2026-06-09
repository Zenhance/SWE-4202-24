public class SMSNotice extends Notice{
    public SMSNotice (Recipient recipient,String text){
        super (recipient,text);
    }
    private int segments(){
        return (text.length()+159)/160;
    }
}
