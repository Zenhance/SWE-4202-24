public class EmailMessage extends Notice {
    public EmailMessage(Recipient recipient,String text){
        super(recipient,text);

    }
    public String deliver(){
        return "An email to "+recipient.getName()+ " "+recipient.getAddress()+" "+text;
    }
    public double cost() {
        return 0.0;


    }
    public String describe(){
        return "Email to"+recipient.getName();
    }



}
