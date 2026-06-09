public class Push extends Notice{
    public Push(){
        super(String channel, String body);
        noticeCount++;
    }
}