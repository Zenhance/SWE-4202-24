public class Main {
    public static void main(String[] args) {

        StudentQueue q = new StudentQueue(5)
            ;


        q.enqueue(new Student("Alice", 80));
        q.enqueue(new Student("Bob", 70));
        q.enqueue(new Student("Charlie", 60));
        q.enqueue(new Student("David", 90));
        q.enqueue(new Student("Eve", 100));


        q.dequeue();
        q.dequeue();
        q.dequeue();

        q.Display();

    }
}
