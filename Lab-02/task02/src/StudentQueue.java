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
    private String[] name = new String[50];
    private int[] marks = new int[50];
    private int count = 0;

    public void enqueue(String name, int marks) {
        if (count + 1 > 50){
            System.out.println("Queue is full");
            return;
        }
        this.name[count] = name;
        this.marks[count] = marks;
        count++;
    }

    public void dequeue(){
        if (count - 1 < 0) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println(this.name[0] + " " + this.marks[0]);
        for (int i = 0; i < count-1; i++){
            this.name[i] = this.name[i+1];
            this.marks[i] = this.marks[i+1];
        }
        count--;
    }

    public void front(){
        System.out.println(this.name[0] + " " + this.marks[0]);
    }

    public void display(){
        for (int i = 0; i < count; i++){
            System.out.println(this.name[i] + " " + this.marks[i]);
        }
    }

}
