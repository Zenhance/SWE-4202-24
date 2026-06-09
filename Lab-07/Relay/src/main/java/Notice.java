public abstract class Notice {
       private Recipient recipient;
       private String str;


    public Notice(Recipient recipient, String str){
    this.recipient=recipient;
    this.str=str;
}
    public Recipient getRecipient() {
        return recipient;
    }

    public String getStr() {
        return str;
    }
    public abstract String deliver();
    public abstract double cost();
    public abstract String describe();

}
