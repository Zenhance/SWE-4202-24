public class Email extends Notice{

    public Email(Recipient recipient, String text) {
        super(recipient, text);
    }

    public String deliver(){
        String header= getRecipient().name;
        String address= getRecipient().getAddress();
        String s = header + address + getText();
        return s;
    }
}
