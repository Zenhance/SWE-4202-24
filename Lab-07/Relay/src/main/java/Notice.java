public abstract class Notice {
    protected Recipient recipient;
    protected String text;
    public Notice(Recipient recipient,String text){
        this.recipient=recipient;
        this.text=text;
    }
    //method
    public abstract String deliver();
    public abstract double cost();
    public abstract String describe();
}
