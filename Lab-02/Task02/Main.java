
public class Main {

    public static void main(String[] args) {

        // Stack Func
        StudentStack stack = new StudentStack();

        // Implementing push() , pop() , peek(), display()
        for (int i = 0; i <= 5; i++) {
            stack.push("Student" + i, i + 50);
        }

        stack.peek();

        stack.pop();
        stack.pop();
        stack.pop();

        stack.display();

        // Queue Func
        StudentQueue queue = new StudentQueue();

        // Implementing enqueue , dequeue , front and display method
        for (int i = 0; i <= 5; i++) {
            queue.enqueue("Student" + i, i + 50);
        }

        queue.front();
    }
}
