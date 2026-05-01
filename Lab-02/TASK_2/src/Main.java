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
        System.out.println("Student Stack : ");
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
public class Main
{
    public static void main(String[] args)
    {
        StudentStack stack=new StudentStack();

        stack.push("Zunied",90);
        stack.push("Raiyan",80);
        stack.push("Rusafi",75);
        stack.push("Tajwar",97);
        stack.push("Tanvir",86);

        stack.peek();

        stack.pop();
        stack.pop();
        stack.pop();

        stack.display();

        StudentQueue queue=new StudentQueue();

        queue.enqueue("Zunied",90);
        queue.enqueue("Raiyan",80);
        queue.enqueue("Rusafi",75);
        queue.enqueue("Tajwar",97);
        queue.enqueue("Tanvir",86);

        queue.front();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.display();
    }
}
//StudentStack
//
//a. Push and Pop do not shift elements. Therefore, the speed remains the same for each cases that means whether there are 5 students or 50 students the speed remains same.
//
//b. If someone writes code using both classes at same time, there will be no interfere with another because each object has separate memory. 'count' variable is private and it belongs to each of them independently.
//
//StudentQueue
//
//a. Every time dequeue shifts remaining all elements to the left. For 50 students and 45 dequeues, the individual element moves required in total is roughly 1000.
//
//
//b. We make the array private so that the outside code can not directly modify it. Because of this different classes use same internal structure safely.