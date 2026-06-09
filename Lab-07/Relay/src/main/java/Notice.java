public abstract class Notice{
    public String channel;
    public String body;
    public
    protected static int noticeCount = 0;


    public int findBodyLength(body){
        return body.length();
    }

    public int len = findBodyLength();

    public int countSegments(len){
        double s =len / 160.00;
        int seg = Math.ceil(s);
        return seg;
    }
}