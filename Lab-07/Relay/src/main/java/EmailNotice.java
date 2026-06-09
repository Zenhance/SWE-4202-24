public class EmailNotice extends Notice {

    private double cost;

    //constructor
    public EmailNotice (Recipient recipient, String text, String cost) {
        super(text, recipient);

        this.cost = 0.0;
    }
}