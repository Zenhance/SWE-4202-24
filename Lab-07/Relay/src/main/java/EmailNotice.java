public class EmailNotice extends Notice{
    public EmailNotice(Recipient recipient,String text){
        super(recipient,text);
    }
    @Override
    public String deliver(){
        return  "E-mail to:"+recipient.getName()+recipient.getAddress()+text;
    }

    @Override
    public double cost() {
        return 0;
    }

    @Override
    public String describe() {
        return "Email Notice";
    }
}
