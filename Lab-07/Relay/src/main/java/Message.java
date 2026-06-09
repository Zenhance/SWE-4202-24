public class Message {
    private Recipient recipient;
    private String text;

    public Message(Recipient recipient, String text){
        this.recipient = recipient;
        this.text = text;
    }

    public String deliver(){
        return "";
    }

    public double cost(){
        return 0.0;
    }

    public String describe(){
        return "";
    }

}
