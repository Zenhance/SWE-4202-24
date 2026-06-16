public class Notice {
    private  Recipient recipient;
    private  String text;

    public Notice(Recipient recipient,String text){
        this.recipient=recipient;
        this.text=text;
    }

    public Recipient getRecipient() {
        return recipient;
    }
    public String getText(){
        return text;
    }
}
