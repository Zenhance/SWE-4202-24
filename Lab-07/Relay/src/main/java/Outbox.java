
    public class Outbox {
        private static final int MAX = 100;

        private final Message[] queue;
        private int count;

        public Outbox() {
            queue = new Message[MAX];
            count = 0;
        }

        public void enqueue(Message message) {
            if (count < MAX) {
                queue[count++] = message;
            }
        }

        public void enqueue(Message message, int times) {
            for (int i = 0; i < times && count < MAX; i++) {
                queue[count++] = message;
            }
        }
        public int size() {
            return count;
        }
        public String flush() {
            StringBuilder log = new StringBuilder();
            for (int i = 0; i < count; i++) {
                if (i > 0) log.append("\n");
                log.append(queue[i].deliver());
            }
            count = 0;   // outbox is empty after a flush
            return log.toString();
        }

        public double totalCost() {
            double total = 0.0;
            for (int i = 0; i < count; i++) {
                total += queue[i].cost();
            }
            return total;
        }
    }