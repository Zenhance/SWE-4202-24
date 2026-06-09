public abstract class Notice {
    private String channel;
    private String body;

    public Notice(String channel, String body) {
        this.channel = channel;
        this.body = body;
    }

    public abstract String transmit(String channel, String body);

    public abstract double cost();
}
