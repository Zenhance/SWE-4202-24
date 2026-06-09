public class EmailNotice extends Notice {
public EmailNotice(Recipient recipient, String text){
    super(recipient,text);
}

@Override
    public String deliver(){
    return "E-mail to "+getRecipient().getName()+" <"+getRecipient().getAddress()+">: "+getText();
}
}
