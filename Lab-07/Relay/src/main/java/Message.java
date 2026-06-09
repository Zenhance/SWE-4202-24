public class Message {

    private final Recipient NAME;
    private String text;


    public Message(Recipient name,String text) {
        NAME = name;
        this.text=text;
    }
}
