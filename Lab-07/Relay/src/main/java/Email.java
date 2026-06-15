public class Email extends Notice{
    String header;
    public Email(String notice_text, String recipient, String header){
        super(recipient, notice_text);
        this.header = header;
    }
    public String send(){
        header = getRecipient().
    }

}
