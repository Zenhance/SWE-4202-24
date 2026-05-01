
public class Main {
    public static void main(String[] args) {

        StudentStack stack = new StudentStack(10);
        StudentQueue queue = new StudentQueue(10);

        stack.push("Bayezid", 85);
        stack.push("Tarik", 90);
        stack.push("prohor", 78);
        stack.push("Jahid", 88);
        stack.push("Tiham", 95);
        System.out.println();
        stack.peek();
        System.out.println();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println();
        stack.display();

        queue.enqueue("Bayezid", 85);
        queue.enqueue("Tarik", 90);
        queue.enqueue("Prohor", 78);
        queue.enqueue("Jahid", 88);
        queue.enqueue("Tiham", 95);
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