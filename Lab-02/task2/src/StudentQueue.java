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
        if (front == rear) {
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