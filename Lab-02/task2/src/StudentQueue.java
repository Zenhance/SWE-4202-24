class StudentQueue {
    String[] names;
    int[] marks;
    int front, rear;
    final int MAX = 100;

    public StudentQueue() {
        names = new String[MAX];
        marks = new int[MAX];
        front = 0;
        rear = 0;
    }

    public void enqueue(String name, int mark) {
        if (rear >= MAX) {
            System.out.println("Queue is full!");
            return;
        }

        names[rear] = name;
        marks[rear] = mark;
        rear++;
    }
}