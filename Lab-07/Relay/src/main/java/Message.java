public class Message {
    private Recipient recipient;
    private String bodytext;

    public Message(Recipient recipient,String bodytext){
        this.recipient=recipient;
        this.bodytext=bodytext;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public String getBodytext() {
        return bodytext;
    }
}

