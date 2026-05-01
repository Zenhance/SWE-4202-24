public class Main {
    public static void main(String[] args) {

        StudentStack stack = new StudentStack(10);
        StudentQueue queue = new StudentQueue(10);

        stack.push("Lamisaa",99);
        stack.push("Nishu",98);
        stack.push("Mahdia",96);
        stack.push("Afsana_jemi",70);
        stack.push("Tanbir",75);
        System.out.println();
        stack.peek();
        System.out.println();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println();
        stack.display();

        queue.enqueue("Lamisaa",99);
        queue.enqueue("Nishu",98);
        queue.enqueue("Mahdia",96);
        queue.enqueue("Afsana_jemi",70);
        queue.enqueue("Tanbir",75);
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