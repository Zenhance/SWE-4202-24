public class EmailNotice extends Notice{
    public EmailNotice(Recipient r,String text){
        super(r,text);
    }
    @Override
    public String deliver() {
        return "Email to "+recipient.getName;
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
