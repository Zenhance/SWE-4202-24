public abstract class Notice {
        Recipient r;
        String body;

        public Notice(Recipient r, String body) {
            if(body.isBlank()){
                throw new IllegalArgumentException("Text cannot be empty.");
            }
            this.r = r;
            this.body = body;
        }

        public abstract double cost();
        public abstract String deliver();
        public abstract String describe();
}
