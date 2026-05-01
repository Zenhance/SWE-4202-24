//StudentQueue
//
//a. Every time dequeue shifts remaining all elements to the left. For 50 students and 45 dequeues, the individual element moves required in total is roughly 1000.
//
//
//b. We make the array private so that the outside code can not directly modify it. Because of this different classes use same internal structure safely.
public class StudentQueue
{
    private String[] names;
    private int[] marks;
    private int count;
    private int total=5;

    public StudentQueue()
    {
        this.names=new String[total];
        this.marks=new int[total];
        this.count=0;
    }

    public void enqueue(String name, int mark)
    {
        if(count==total)
        {
            System.out.println("Queue Is Full!");
        }
        names[count]=name;
        marks[count]=mark;
        count++;
    }
    public void dequeue()
    {
        if(count==0)
        {
            System.out.println("Queue Is Empty!");
        }
        System.out.println("Removed Student : "+names[0]+" "+marks[0]);

        for(int i=0;i<count-1;i++)
        {
            names[i]=names[i+1];
            marks[i]=marks[i+1];
        }
        count--;
    }

    public void front()
    {
        if(count==0)
        {
            System.out.println("Queue Is Empty!");
        }
        System.out.println("Student At Front : "+names[0]+" "+marks[0]);
    }

    public void display()
    {
        System.out.println("Student Queue : ");
        for(int i=0;i<count;i++)
        {
            System.out.println(names[i]+" "+marks[i]);
        }
    }
}