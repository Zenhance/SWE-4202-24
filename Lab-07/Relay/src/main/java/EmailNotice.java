public class EmailNotice extends Notice{
    public EmailNotice(Recipient recipient, String text) {
       super(recipient, text);
    }

    
    public String deliver(){
        return "EMAIL to " + getRecipient().getName()+ "<" + getRecipient().getAddress() + ">" + getText();
    }

    public double cost(){
        return 0.0;
    }

    public String describe(){
        return "Email Notice";
    }

}
