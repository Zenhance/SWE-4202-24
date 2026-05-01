//StudentStack
//
//a. Push and Pop do not shift elements. Therefore, the speed remains the same for each cases that means whether there are 5 students or 50 students the speed remains same.
//
//b. If someone writes code using both classes at same time, there will be no interfere with another because each object has separate memory. 'count' variable is private and it belongs to each of them independently.
//
public class StudentStack
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
        System.out.println("Student Stack : ");
        for(int i=0;i<count;i++)
        {
            System.out.println(names[i]+" "+marks[i]);
        }
    }
}