public class Main{
    public static void main(String[] args){
        String[] names = new String[100];
        int[] marks = new int[100];

        System.out.println("For Stack:");

        StudentStack stack = new StudentStack(names, marks);
        stack.push("Alice",100);
        stack.push("Bob",90);
        stack.push("Jenny",80);
        stack.push("Clinton",70);
        stack.push("Fred",85);

        stack.peek();

        stack.pop();
        stack.pop();
        stack.pop();

        stack.display();

        System.out.println("For Queue:");

        StudentQueue queue = new StudentQueue(names, marks);
        queue.enqueue("Alice",100);
        queue.enqueue("Bob",90);
        queue.enqueue("Jenny",80);
        queue.enqueue("Clinton",70);
        queue.enqueue("Fred",85);

        queue.front();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.display();
    }
}
