class StudentStack
{
    private String[] names;
    private int[] marks;
    private int count;
    private int total=5;

    public StudentStack()
    {
        this.names=new String[total];
        this.marks=new int[total];
        this.count=0;
    }

    public void push(String name, int mark)
    {
        if(count==total)
        {
            System.out.println("Stack Is Full!");
        }
        names[count]=name;
        marks[count]=mark;
        count++;
    }

    public void pop()
    {
        if(count==0)
        {
            System.out.println("Stack Is Empty!");
        }
        count--;
        System.out.println("Removed Student : "+names[count]+" "+marks[count]);
    }

    public void peek()
    {
        if(count==0)
        {
            System.out.println("Stack Is Empty!");
        }
        System.out.println("Student At Top : "+names[count-1]+" "+marks[count-1]);
    }

    public void display()
    {
        System.out.println("Student List : ");
        for(int i=0;i<count;i++)
        {
            System.out.println(names[i]+" "+marks[i]);
        }
    }
}
class StudentQueue
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
        count--;
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

    }

    public void display()
    {

    }
}
public class Main
{
    public static void main(String[] args)
    {

    }
}