public class Notice{
    public String channel;
    public String body;
    protected static int noticeCount = 0;

    public Notice(String channel, String body) {
        this.channel = channel;
        this.body = body;
        noticeCount++;
    }

    public void addRecipient(){

    }
}