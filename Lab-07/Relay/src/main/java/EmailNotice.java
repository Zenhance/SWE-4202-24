public class EmailNotice extends Notice {

    public EmailNotice(Recipient recipient, String body) {

        super(recipient, body);
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

