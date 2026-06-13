public class EmailMessage extends Message {

    private String name;
    private String text;

    public EmailMessage(Recipient name,String text){
        super(name,text);
    }
    public String deliver(){
        return text;
    }
    public double cost(){
        return 0.0;
    }
    public String describe() {
        return "Email to "+this.name;
    }

}
