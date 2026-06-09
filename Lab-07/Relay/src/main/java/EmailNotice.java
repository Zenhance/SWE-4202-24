public class EmailNotice extends Notice {

    private double cost;

    //constructor
    public EmailNotice (Recipient recipient, String text) {
        super(text, recipient);

    }

    String medium(){
        return "EMAIL";
    }

    double cost(){
        return 0.0; //no cost for email
    }
}