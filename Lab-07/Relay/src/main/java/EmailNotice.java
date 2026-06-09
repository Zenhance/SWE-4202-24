public class EmailNotice extends Notice {
    public EmailNotice(Recipient recipient,String text){
        super(recipient,text);
    }
    @Override
    public String deliver(){
        return "EMAIL TO: " + recipient.getName()+"\n" + text;
    }
}
