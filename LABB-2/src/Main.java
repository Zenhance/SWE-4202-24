public class Main {
    public static void main(String[] args) {
        StudentStack stack = new StudentStack();

        stack.push("Anisha", 80);
        stack.push("Amina", 85);
        stack.push("Cicilia", 90);
        stack.push("Miami", 75);
        stack.push("Ayra", 88);

        stack.peek();
        stack.pop();
        stack.pop();
        stack.pop();

        stack.display();

        System.out.println("-----");
        StudentQueue queue = new StudentQueue();

        queue.enqueue("Anisha", 80);
        queue.enqueue("Amina", 85);
        queue.enqueue("Cicilia", 90);
        queue.enqueue("Miami", 75);
        queue.enqueue("Ayra", 88);

        queue.front();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.display();
    }
}