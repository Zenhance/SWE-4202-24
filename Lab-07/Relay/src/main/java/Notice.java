public  abstract class Notice {
    public final Recipient recipient;

    public Notice( Recipient recipient) {
        this.recipient = recipient;
    }

    public abstract String deliver();
    public abstract double cost();
    public abstract String describe();

    public String getRecipentName(){
        return recipient.getName();
    }
     public String getRecipientAddress(){
        return recipient.getAddress();
     }

}
