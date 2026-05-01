public class main {
    public static void main(String[] args) {
        StudentStack stack=new StudentStack();
        stack.push("Sadman",86);
        stack.push("Raiyan",78);
        stack.push("Syed",87);
        stack.push("Baba",88);
        stack.push("Naz",67);

        stack.peek();

        stack.pop();
        stack.pop();
        stack.pop();

        stack.display();


        StudentQueue queue=new StudentQueue();
        queue.enqueue("Sadman",86);
        queue.enqueue("Raiyan",78);
        queue.enqueue("Syed",87);
        queue.enqueue("Baba",88);
        queue.enqueue("Naz",67);

        queue.front();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.display();



    }
}
