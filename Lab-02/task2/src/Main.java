
public class Main {
    public static void main(String[] args) {

        StudentStack stack = new StudentStack(10);
        StudentQueue queue = new StudentQueue(10);

        stack.push("Rahim", 85);
        stack.push("Karim", 90);
        stack.push("Rafiq", 78);
        stack.push("Jabbar", 88);
        stack.push("Siam", 95);
        System.out.println();
        stack.peek();
        System.out.println();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println();
        stack.display();

        queue.enqueue("Rahim", 85);
        queue.enqueue("Karim", 90);
        queue.enqueue("Rafiq", 78);
        queue.enqueue("Jabbar", 88);
        queue.enqueue("Siam", 95);
        System.out.println();
        queue.front();
        System.out.println();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println();
        queue.display();

    }

}