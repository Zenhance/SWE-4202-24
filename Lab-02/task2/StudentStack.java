//StudentStack (a): The speed is the same for 5 or 50 students. Since there is no shifting, the operation takes
// the same amount of time regardless of size (O(1) complexity).
// StudentStack (b): No, they cannot interfere. Each object has its own separate memory space for its count field,
// so changing one does not affect the other.
class StudentStack {
    String[] names;
    int[] marks;
    int count;
    final int MAX = 100;

    public StudentStack()
    {
        names = new String[MAX];
        marks = new int[MAX];
        count = 0;
    }
    public void push(String name, int mark)
    {
        if (count >= MAX)
        {
            System.out.println("Stack is full!");
            return;
        }
        names[count] = name;
        marks[count] = mark;
        count++;
    }
    public void pop()
    {
        if (count == 0)
        {
            System.out.println("Stack is empty!");
            return;
        }
        count--;
        System.out.println("Popped:"+names[count]+"("+marks[count]+")");
    }
    public void peek()
    {
        if (count == 0)
        {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.println("Top:"+names[count-1]+"("+marks[count-1]+")");
    }
    public void display()
    {
        for (int i=0;i<count;i++)
        {
            System.out.println(names[i]+"("+marks[i]+")");
        }
    }
}