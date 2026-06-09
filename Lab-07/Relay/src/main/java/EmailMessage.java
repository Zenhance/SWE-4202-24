public class EmailMessage extends Notices {

    public EmailMessage(Recipient r, String text) {
        super(r,text);
    }

    public String deliver(){
        return "Email to" + recipient.getName();
    }

    public int cost(){
        return 0;
    }

    public String describe() {
        return "Email Notice";
    }
}
