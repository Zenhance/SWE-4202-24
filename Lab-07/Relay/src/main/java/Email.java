public class Email extends Notice {
    public Email(String channel, String body) {
        super(channel, body);
    }
    public String transmit(String channel, String body){
        return channel + body;
    }
    public double cost(){
        return 0.00;
    }
}
