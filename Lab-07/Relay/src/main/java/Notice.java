public abstract class Notice {

    //fields
    private String text;
    private Recipient recipient;

    //constructor
    public Notice (String text, Recipient recipient) {
        this.text = text;
        this.recipient = recipient;
    }

    public String getText() {
        return text;
    }

    public abstract String medium();
    public abstract double cost();
    public abstract String read();

}