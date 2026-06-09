public class Sms extends Notice {
    public Sms(String channel, String body) {
        super(channel, body);
    }
    private int segments = body.length() / 160;

    public String transmit(String channel, String body){
        return
    }


}
