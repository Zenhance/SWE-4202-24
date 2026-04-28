public class Main {

    public static void main(String[] args) {
        System.out.println("Main runs");

        // For Stack
        StudentStack stack = new StudentStack();

        // Implementing push() method
        for (int i = 1; i <= 5; i++){
            stack.push("Student"+i, i+50);
        }

        // Implementing peek() method
        stack.peek();

        // Implementing pop() method
        stack.pop();
        stack.pop();
        stack.pop();

        // Implementing display() method
        stack.display();

        // For Queue
        StudentQueue queue = new StudentQueue();

        // Implementing enqueue method
        for (int i = 1; i <= 5; i++){
            queue.enqueue("Student"+i, i+50);
        }

        // Implementing dequeue method
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }
}
