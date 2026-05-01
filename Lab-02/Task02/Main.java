
public class Main {

    public static void main(String[] args) {
        System.out.println("Main\n");

        System.out.println("Running Stack\n");

        // Stack Func
        StudentStack stack = new StudentStack();

        // Implementing push() , pop() , peek(), display()
        for (int i = 1; i <= 5; i++) {
            stack.push("Student " + i, i + 50);
        }

        stack.peek();

        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println("In stack: ");
        stack.display();

        System.out.println("\nRunning Queue\n");
        // Queue Func
        StudentQueue queue = new StudentQueue();

        // Implementing enqueue , dequeue , front and display method
        for (int i = 1; i <= 5; i++) {
            queue.enqueue("Student " + i, i + 50);
        }

        queue.front();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.display();
    }
}
