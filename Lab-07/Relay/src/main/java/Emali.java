public class Emali extends Notice{
    public Email(Recipient recipient, String text){
        super(recipient, text);
    }
    @Override
    public String deliver(){
        return "To: " + recipient.getName() + " (" + recipient.getAddress() + ")\n" + text;
    }
    @Override
    public double price(){
        return 0.0;
    }
    @Override
    public String describe(){
        return "Email notice to: " + recipient.getName();
    }
}