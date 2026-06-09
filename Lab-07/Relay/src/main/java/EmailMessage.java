public class EmailMessage extends Message {
public EmailMessage(Recipient recipient, String text){
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
    return "EMAIL message to "+getRecipient().getName();
}
}
