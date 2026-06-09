public class Email extends Notice{
    public Email(Recipient recipient, String text){
        super(recipient,text);
    }
    @Override
    public String deliver(){
        return " Email to " +  recipient.getName() + "<" + recipient.getAddress() + ">:" + text;
    }
    @Override
    public double cost(){
     return 0.0;
    }
    @Override
    public String describe(){
        return "Email Notice";
    }
}
