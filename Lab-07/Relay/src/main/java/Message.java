public abstract class Message {
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

    public abstract String deliver();
    public abstract double cost();
    public abstract String describe();


}

