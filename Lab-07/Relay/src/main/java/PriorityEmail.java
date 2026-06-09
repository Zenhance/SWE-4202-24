class PriorityEmail extends Email {
    private final double surcharge = 1.50; // Example fixed value, adapt to test spec if needed

    public PriorityEmail(Recipient recipient, String text) {
        super(recipient, text);
    }
}