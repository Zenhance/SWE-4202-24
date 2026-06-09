public class EmailNotice extends Notice {
public EmailNotice(Recipient recipient, String text){
    super(recipient,text);
}

@Override
    public String deliver(){
    return "E-mail to "+getRecipient().getName()+" <"+getRecipient().getAddress()+">: "+getText();
}
@Override
    public double cost(){
    return 0.0;
}
@Override
    public String describe(){
    return "E-mail notice to "+getRecipient().getName();
}
}
