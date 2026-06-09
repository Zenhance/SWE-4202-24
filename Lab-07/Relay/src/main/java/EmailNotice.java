public class EmailNotice extends Notice {

    private double cost;

    //constructor
    public EmailNotice (Recipient recipient, String text) {
        super(text, recipient);

    }
}