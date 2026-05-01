/*

 QUESTIONS:-
a. How many element moves does dequeue() require?
b. Why does making the array private make all three classes
   (StudentList, StudentStack, StudentQueue) possible?

 ANSWERS:-
a. Every call to dequeue() shifts ALL remaining elements one
   step to the left. If the queue holds 50 students and I
   dequeue 45 times:
     Call 1 : 49 shifts  (50 - 1)
     Call 2 : 48 shifts  (49 - 1)
     ...
     Call 45: 5  shifts  (6  - 1)
     Total = 49 + 48 + 47 + ... + 5
         = sum from 5 to 49
         = (49 × 50 / 2) − (4 × 5 / 2)
         = 1225 − 10  =  1215 individual element moves.

b. Because private hides the array from outside code, each
   class is free to enforce its own access rule (any position,
   LIFO, or FIFO) through its methods alone — callers can never
   bypass the rule by indexing the array directly.
*/

package Task2;

public class StudentQueue
{
    private int count = 0;
    private String[] names = new String[10];
    private int[] marks = new int[10];

    public void enqueue(String name, int obtained_mark)
    {
        if(count >= 10)
        {
            System.out.println("Error. Queue is full.");
        }
        else
        {
            names[count] = name;
            marks[count] = obtained_mark;
            count++;
        }
    }

    public void dequeue()
    {
        if(count == 0)
        {
            System.out.println("Error. Queue is empty.");
        }
        else
        {
            System.out.println(names[0] + " with " + marks[0] + " has been dequeued.");
            for(int i = 0; i < count - 1; i++)
            {
                names[i] = names[i + 1];
                marks[i] = marks[i + 1];
            }
            count--;
        }
    }


}
