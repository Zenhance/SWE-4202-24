public class Push extends Notice {
    private final double flatRate = 0.10; // Adjust based on test spec

    public Push(Recipient recipient, String text) {
        super(recipient, text);
    }

    private String getPreviewText() {
        if (text.length() <= 40) {
            return text;
        }
        return text.substring(0, 40); // Safe extraction
    }
}