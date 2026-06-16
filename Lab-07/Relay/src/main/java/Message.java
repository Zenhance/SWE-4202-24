public abstract class Message {
    public Recipient r;
    public String line;

    public Message(Recipient r, String line) {
        this.r = r;
        this.line = line;
    }

    public abstract String deliver();
    public abstract double cost();



}
