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
/*
    a.
        Since each dequeue operation requires shifting all remaining count - 1 elements,
        the total moves for 45 dequeues form a decreasing arithmetic series.
        1st dequeue: 49 moves
        45th dequeue: 5 moves
        Total Moves :n/2(first+last)
                    =45/2(49+5)
                    =1215 individual moves

    b.
        As we are hiding the arrays we need to access via methods where their push/enqueue
        or pop/dequeue
        methods differ.
*/