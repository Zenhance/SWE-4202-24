public class PriorityEmailNotice extends EmailNotice{
    public PriorityEmailNotice(Recipient recipient,String text){
        super(recipient,text);
    }
    @Override
    public String deliver(){
        return "[PRIORITY] " + super.deliver();
    }
}
