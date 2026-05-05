//StudentQueue (a): It would require roughly 1,125 moves.
//(Calculation: The first dequeue moves 49, the second 48... until the 45th dequeue moves 5.
// The sum of $49+48...+5 \approx 1215$ moves).
//StudentQueue (b): Hiding the array as private allows the class to strictly control how data is accessed,
//ensuring that a Stack only uses "top" logic and a Queue only uses "front/back" logic without outside code
//bypassing these rules[cite: 1].
class StudentQueue {
    String[] names;
    int[] marks;
    int front, rear;
    final int MAX = 100;

    public StudentQueue()
    {
        names = new String[MAX];
        marks = new int[MAX];
        front = 0;
        rear = 0;
    }
    public void enqueue(String name, int mark)
    {
        if (rear >= MAX)
        {
            System.out.println("Queue is full!");
            return;
        }

        names[rear] = name;
        marks[rear] = mark;
        rear++;
    }
    public void dequeue()
    {
        if (front == rear)
        {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.println("Removed: " + names[front] + " (" + marks[front] + ")");
        front++;
    }
    public void peek()
    {
        if (front == rear)
        {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.println("Front: " + names[front] + " (" + marks[front] + ")");
    }
    public void display()
    {
        for (int i = front; i < rear; i++)
        {
            System.out.println(names[i] + " (" + marks[i] + ")");
        }
    }
}