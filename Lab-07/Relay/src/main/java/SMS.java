public class SMS extends Notice {
    private final double costPerSegment = 0.05; // Adjust according to your test file specifications

    public SMS(Recipient recipient, String text) {
        super(recipient, text);
    }

    private int getSegmentCount() {
        if (text == null || text.isEmpty()) return 0;
        return (int) Math.ceil((double) text.length() / 160);
    }
}