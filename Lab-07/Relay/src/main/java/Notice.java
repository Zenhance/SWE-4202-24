abstract class Notice {
    private final Recipient recipient;
    private final String text;

    public Notice(Recipient recipient, String text){
        this.recipient = recipient;
        this.text = text;
    }


}
