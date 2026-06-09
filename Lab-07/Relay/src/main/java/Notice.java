public class Notice {
    private  String recipient;
    private  String text;

    public Notice(String recipient,String text){
        this.recipient=recipient;
        this.text=text;
    }

    public String getRecipient() {
        return recipient;
    }
    public String getText(){
        return text;
    }
}
