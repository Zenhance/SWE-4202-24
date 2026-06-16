public class EmailMessage extends Message{
          public Recipient r;
          public String body;
        final double cost=0.0;
    public EmailMessage(Recipient r, String body) {
        super(r,body);

    }
    public String deliver(){
        return super.deliver();
    }
    public double cost() {
        return super.cost();
    }

}
