/*
PART-C.1:

    a. The speed will remain the same for both 50 v/s 5 students... or even 50k
       Because, in push() and pop(), we only dealing with the LAST element of the array without
       making any change in any other element.

    b. If someone writes code that uses both classes at the same time,
       then that means, they will have different objects.
           Maybe,
                StudentQueue obj1
                StudentStack obj2
           obj1.count will be at a different memory than obj2.count
           and because fo private count, we cannot directly modify or touch them either.
           So, they cannot interfere each other.

*/

public class StudentStack {

    private String[] names = new String[50];
    private int[] marks = new int[50];
    private int count;


    public void push (String n, int m){
        if (count < 50) {
            names[count] = n;
            marks[count] = m;
            System.out.println("Adding to the stack: "+names[count]+" ("+marks[count]+")");
            count++;
        }
        else System.out.println("Sorry! Can't add more students, the stack is full");
    }
    public void pop (){
        if (count == 0)
            System.out.println("Sorry! Can't remove any student, the stack is empty");
        else {
            int x = count - 1;
            System.out.println("Removing from the stack: "+names[x]+" ("+marks[x]+")");
            names[x] = null;
            marks[x] = 0;
            count--;
        }
    }
    public void peek(){
        int x = count - 1;
        System.out.println("Student at peek: "+names[x]+" ("+marks[x]+")");
    }
    public void display ()
    {
        System.out.println("THE STACK:");

        for(int i=0; i<count; i++)
        {
            System.out.println((i) + " " + names[i] + " " + marks[i]);
        }
    }
}