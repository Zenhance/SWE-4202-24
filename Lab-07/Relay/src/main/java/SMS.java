public class SMS extends Notice {
    private final double costPerSegment = 0.05;
    public SMS(Recipient recipient, String text) {
        super(recipient, text);
    }

    private int getSegmentCount() {
        if (text == null || text.isEmpty()) return 0;
        return (int) Math.ceil((double) text.length() / 160);
    }

    @Override
    public String deliver() {
        return text + "\n[Sent via SMS in " + getSegmentCount() + " segment(s)]";
    }

    @Override
    public double cost() {
        return getSegmentCount() * costPerSegment;
    }

    @Override
    public String describe() {
        return "SMS notice to " + recipient.getName() + " (" + getSegmentCount() + " segments)";
    }
}