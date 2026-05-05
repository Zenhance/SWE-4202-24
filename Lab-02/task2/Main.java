public class Main {
    public static void main(String[] args) {

        StudentStack stack = new StudentStack();
        stack.push("Safwan", 90);
        stack.push("Ali", 85);
        stack.push("wasif", 88);
        stack.push("madrur", 98);
        stack.display();
        stack.pop();
        stack.peek();

        System.out.println("\n");

        StudentQueue queue = new StudentQueue();
        queue.enqueue("rakin", 70);
        queue.enqueue("wasif", 75);
        queue.enqueue("wasifa", 88);
        queue.enqueue("madrur", 98);
        queue.display();
        queue.dequeue();
        queue.peek();
    }
}