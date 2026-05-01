package src;
public class StudentQueue
{
    private String[] names = new String[99];
    private int[] marks = new int[99];
    private int count = 0;

    public void enqueue(String name, int mark)
    {
        if(count==0)
        {
            System.out.println("Error: Queue is empty.");
        }
        System.out.println("Dequeued: " + names[0] + " " + marks[0]);
        for(int i = 0; i < count - 1; i++)
        {
            names[i] = names[i + 1];
            marks[i] = marks[i + 1];
        }
        count--;
    }
}