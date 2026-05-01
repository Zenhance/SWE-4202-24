/*
    a. dequeue always shifts the entire remaining array one step to the left. If the queue
    holds 50 students and you dequeue 45 times, roughly how many individual element
    moves does that require in total?
    Ans: Total individual moves = n*(n+1)/2 - (1 + 2 + 3 + 4)
                                = 49*50/2 - 10
                                = 1215
        In every dequeue we need to move count-1 elements. Hence, the number of moves per
        dequeue 49, 48, 47, 46,... As we dequeued 45 elements, we do not need to count for last
        4 element's dequeue's move count. Hence, 49*50/2 - 10.

    b. You have now written three classes — StudentList, StudentStack, and StudentQueue
    — all using the same private array and count. The only real difference is which meth-
    ods are available to outside code. In one sentence, explain why hiding the array as
    private makes this possible.
    Ans: As we are hiding the arrays we need to access via methods where their push/enqueue or pop/dequeue
        methods differ.
*/

public class StudentQueue {
    private String[] Names = new String[60];
    private double[] Marks = new double[60];
    private int count = 0;

    public void enqueue(String Names, double Marks) {
        if (count>= 60) {
            System.out.println("Queue is full");
            return;
        }
        this.Names[count] = Names;
        this.Marks[count] = Marks;
        count++;
    }
}