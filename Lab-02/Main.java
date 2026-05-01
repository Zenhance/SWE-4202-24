public class Main {
    public static void main(String[] args) {
        System.out.println("For Student Stack");
        StudentStack s1 = new StudentStack();
        for (int i = 1; i <= 5; i++) {
            s1.push("Student" + i, 50 + i);
        }
        System.out.println("PEEK:");
        s1.peek();
        System.out.println("POP:");
        s1.pop();
        s1.pop();
        s1.pop();
        System.out.println("DISPLAY:");
        s1.display();
        StudentQueue q1 = new StudentQueue();
        for (int i = 1; i <= 5; i++) {
            q1.enqueue("Student" + i, 50 + i);
        }
        System.out.println("FRONT");
        q1.front();
        System.out.println("DEQUEUE");
        q1.dequeue();
        q1.dequeue();
        q1.dequeue();
        System.out.println("DISPLAY");
        q1.display();
    }
}
