public class Main2 {
    public static void main(String[] args) {
        System.out.println("Main runs successfully");

        // For implementing Stack
        StudentStack stack = new StudentStack();

        // Implementing push() method
        for (int i = 1; i <= 5; i++){
            stack.push("Student"+i , i+60);
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
            queue.enqueue("Student"+i, i+60);
        }

        // Implementing front method
        queue.front();

        // Implementing dequeue method
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        // Implementing display method
        queue.display();
    }
}

