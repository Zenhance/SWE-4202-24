/*
PART-C.2:

    a. 45 dequeued students out of 50, each time we shift total-1 students
       Therefore,
                 1st dequeue ----> 50 - 1  = 49 shifts (new total = 49)
                 2nd dequeue ----> 50 - 2  = 48 shifts (new total = 48)
                 3rd dequeue ----> 50 - 3  = 47 shifts (new total = 47)
                 .....................................................
                 .....................................................
                 .....................................................
                45th dequeue ----> 50 - 45 =  5 shifts (new total = 5)

            Total shifts = 49 + 48 + 47 + .... + 5   = 1215 (damn! that's allat :0)

    b. Beacuse the "private" does not give permission to outside code to make any changes
       inside so we can use it for all the classes...

       (
            This phrasing of the question was a bit confusing, would appreciate if you explain elaborately
            in next class/lab...

            Private forces StudentList, StudentStack & StudentQueue - all of these classes
            to have their own list of students, different from one another

            Since, you asked us to use private, so we did...
            because of that, studentList, queue, stack, they are going to need separate storages for students
            names, marks, count inside the class StudentStack cannot be changed by other classes' methods.
            even, we cannot move names, marks, count inside a global static class.
       )

*/

public class StudentQueue {

    private String[] names = new String[50];
    private int[] marks = new int[50];
    private int count;


    public void enqueue(String n, int mark){

        if(this.count >= 50) {
            System.out.println("Sorry! Can't add more students, the queue is full");
            return;
        }
        names[count] = n;
        marks[count] = mark;
        System.out.println("Adding to the queue: "+names[count]+" ("+marks[count]+")");
        count ++;

    }

    public void dequeue(){
        if(count == 0)
            System.out.println("Sorry! Can't remove any student, the queue is empty");
        else {
            System.out.println("Removing from the queue: "+names[0]+" ("+marks[0]+")");
            for (int i = 0; i < (count - 1); i++) {
                names[i] = names[i + 1];
                marks[i] = marks[i + 1];
            }

            names[count - 1] = null;
            marks[count - 1] = 0;
            count -= 1;
        }
    }
    public void front(){
        System.out.println("Student at peek: "+names[0]+" ("+marks[0]+")");
    }
    public void display () {

        System.out.println("THE QUEUE:");

        for(int i=0; i<count; i++)
        {
            System.out.println((i) + " " + names[i] + " " + marks[i]);
        }
    }

}