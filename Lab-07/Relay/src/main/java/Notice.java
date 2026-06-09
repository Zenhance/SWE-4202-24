public class Notice{
    String channel;
    String body;
    static int noticeCount = 0;

    public Notice(String channel, String body) {
        this.channel = channel;
        this.body = body;
        noticeCount++;
    }

    public void addRecipient(){

    }
}