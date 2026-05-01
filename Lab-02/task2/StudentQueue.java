package task2;
/*
a. Every time dequeue() is called, all remaining students are shifted one position to
the left. If there are 50 students, the first dequeue shifts 49 elements, the next one
shifts 48, then 47, and so on. After dequeuing 45 times, the total number of element
moves becomes very large — around 1215 moves in total — which makes dequeue()
slower when the queue size is large.

b. Keeping the array private allows the class to control how the data is used through
specific methods only. Because outside code cannot directly access the array, the
same array structure can   behave like a list, stack, or queue depending on which
methods the class   provides.
*/
public class StudentQueue {
    String[] names;
    double[] marks;
    int count = 0;

    StudentQueue(String[]names, double[] marks){
        this.names = names;
        this.marks = marks;
    }
    public void enqueue (String name,double mark){
        if (count == names.length) {
            System.out.println("Queue is full");
            return;
        }
        this.names[count] = name;
        this.marks[count] = mark;
        count++;
    }
    public void dequeue () {
        if (count == 0) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Name:" + names[0] + " Marks: " + marks[0]);
        for (int i = 0; i < count - 1; i++) {
            names[i] = names[i + 1];
            marks[i]=marks[i+1];
        }
        count--;
    }
    public void front () {
        if(count==0){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Name: " + names[0] + " Marks: " + marks[0]);
    }
    public void display () {
        for (int i = 0; i < count; i++) {
            System.out.println("Name:" + names[i] + " Marks" + marks[i]);
        }
    }

}
