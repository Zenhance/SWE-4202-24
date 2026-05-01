public class Main {
    public static void main(String[] args) {

        StudentStack stack = new StudentStack(10);

        StudentQueue queue = new StudentQueue(10);

        stack.push("Ishmam", 81);

        stack.push("Tahmid", 80);

        stack.push("Tanvir",99);

        stack.push("Adnan", 89);

        stack.push("Mahi",75);

        System.out.println();
        stack.peek();
        System.out.println();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println();
        stack.display();

        queue.enqueue("Ishmam", 81);

        queue.enqueue("Tahmid", 80);

        queue.enqueue("Tanvir",99);

        queue.enqueue("Adnan", 89);

        queue.enqueue("Mahi",75);

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