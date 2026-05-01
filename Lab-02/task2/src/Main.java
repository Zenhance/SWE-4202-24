package src;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        //Stack
        StudentStack Stack = new StudentStack();

        System.out.println("Enter 5 students for Stack: ");
        for(int i = 1; i <= 5; i++)
        {
            System.out.print("Name and Mark " + i + ": ");
            String name = sc.next();
            int mark = sc.nextInt();
            Stack.push(name, mark);
        }
        Stack.pop();
        Stack.peek();
        Stack.display();


        //Queue
        StudentQueue Queue = new StudentQueue();

        System.out.println("Enter 5 students for Queue: ");
        for (int i = 1; i <= 5; i++)
        {
            System.out.print("Name and Mark " + i + ": ");
            String name = sc.next();
            int mark = sc.nextInt();
            Queue.enqueue(name, mark);
        }
        Queue.dequeue();
        Queue.front();
        Queue.display();
        sc.close();
    }
}