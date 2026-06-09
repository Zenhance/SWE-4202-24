public class EmailNotice extends Notice {

    private double cost;

    //constructor
    public EmailNotice (Recipient recipient, String text) {
        super(text, recipient);

    }

    public String medium(){
        return "EMAIL";
    }

    public double cost(){
        return 0.0; //no cost for email
    }

    public string read() {
        return "EMAIL to <" + recipient.getAddress() + " >" + text;

    }
}