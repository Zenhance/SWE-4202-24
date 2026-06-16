public class EmailMessage extends Message{

    public EmailMessage(Recipient r, String body) {
        super(r,body);

    }
    public String deliver(){
        return r.getName()+body;
    }


    public double cost() {
        return 0;
    }
}
