public class EmailNotice extends Notice {
    public EmailNotice(Recipient recipient) {
        super(recipient);
    }

    @Override
    public String deliver() {
        return "";
    }

    @Override
    public double cost() {
        return 0;
    }

    @Override
    public String describe() {
        return "";
    }
}
