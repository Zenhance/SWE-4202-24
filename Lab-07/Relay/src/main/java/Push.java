public class Push extends Notice {
    private final double flatRate = 0.10;

    public Push(Recipient recipient, String text) {
        super(recipient, text);
    }

    private String getPreviewText() {
        if (text.length() <= 40) {
            return text;
        }
        return text.substring(0, 40);
    }

    @Override
    public String deliver() {
        return "[Push Preview] " + getPreviewText();
    }

    @Override
    public double cost() {
        return flatRate;
    }

    @Override
    public String describe() {
        return "Push notification to " + recipient.getName();
    }
}