package task2;

/*

 */

public class Main {

    public static void main(String[] args) {
        System.out.println("Main runs");

        StudentStack stack = new StudentStack();

        for (int i = 1; i <= 5; i++){
            stack.push("Student"+i, i+50);
        }

        stack.peek();

        stack.pop();
        stack.pop();
        stack.pop();

        stack.display();

        StudentQueue queue = new StudentQueue();

        for (int i = 1; i <= 5; i++){
            queue.enqueue("Student"+i, i+50);
        }

        queue.front();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.display();
    }
}
