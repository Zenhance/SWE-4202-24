public class Email extends Notice{

    public boolean priority = false;
    public Email(){
        super(String channel, String body);
        noticeCount++;
    }
}