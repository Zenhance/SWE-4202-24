class StudentStack {
    String[] names;
    int[] marks;
    int count;
    final int MAX = 100;

    public StudentStack() {
        names = new String[MAX];
        marks = new int[MAX];
        count = 0;
    }

    public void push(String name, int mark) {
        if (count >= MAX) {
            System.out.println("Stack is full!");
            return;
        }
        names[count] = name;
        marks[count] = mark;
        count++;
    }
}