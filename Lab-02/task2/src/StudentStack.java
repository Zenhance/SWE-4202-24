package src;
public class StudentStack
{
    private String[] names = new String[99];
    private int[] marks = new int[99];
    private int count = 0;

    public void push(String name, int mark)
    {
        if (count >= 99)
        {
            System.out.println("Error: Stack is full.");
        }
        else
        {
            names[count] = name;
            marks[count] = mark;
            count++;
        }
    }

    public void pop()
    {
        if(count == 0)
        {
            System.out.println("Error: Stack is empty.");
            return;
        }
        count--;
        System.out.println("Popped: " + names[count] + " " + marks[count]);
    }

    public void peek()
    {
        System.out.println("Top: " + names[count - 1] + " " + marks[count - 1]);
    }

    public void display()
    {
        System.out.println("(Top)");
        for (int i = count - 1; i >= 0; i--)
        {
            System.out.println(names[i] + " " + marks[i]);
        }
        System.out.println("(Bottom)");
    }
}