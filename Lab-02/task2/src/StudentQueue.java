package src;
public class StudentQueue
{
    private String[] names = new String[99];
    private int[] marks = new int[99];
    private int count = 0;

    public void enqueue(String name, int mark)
    {
        if(count >= 99)
        {
            System.out.println("Error: Queue is full.");
        }
        else
        {
            names[count] = name;
            marks[count] = mark;
            count++;
        }
    }

    public void dequeue()
    {
        if(count == 0)
        {
            System.out.println("Error: Queue is empty.");
        }
        else
        {
            System.out.println("Dequeued: " + names[0] + " " + marks[0]);
            for(int i = 0; i < count - 1; i++)
            {
                names[i] = names[i + 1];
                marks[i] = marks[i + 1];
            }
            count--;
        }
    }

    public void front()
    {
        if(count == 0)
        {
            System.out.println("Error: Queue is empty.");
        }
        else
        {
            System.out.println("Front: " + names[0] + " " + marks[0]);
        }
    }

    public void display()
    {
        System.out.println("(Front)");
        for(int i = 0; i < count; i++)
        {
            System.out.println(names[i] + " " + marks[i]);
        }
        System.out.println("(Rear)");
    }
}
/*
    a.
      Since push and pop operations interact only with the top of the stack without shifting elements,
      their execution time is constant (O(1)).This means the speed of a single operation remains exactly
      the same regardless of whether the stack contains 5 students or 50 students.

    b.
      No, they cannot interfere because each instance of a class occupies its own unique memory space,
      and the private modifier ensures that each object's data is isolated and accessible only through
      its own methods.
*/