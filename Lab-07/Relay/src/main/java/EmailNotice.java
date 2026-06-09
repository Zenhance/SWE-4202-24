public class EmailNotice extends Notice{
    public EmailNotice(Recipient recipient, String text){
        super(recipient, text);
    }
    public String deliver(){
        return  "EMAIL to" + getRecipient.getname() + " <" + getRecipient().getAddress()+ ">: " +
    }
}
