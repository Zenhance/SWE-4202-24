/*
a. dequeue always shifts the entire remaining array one step to the left. If the queue
holds 50 students and you dequeue 45 times, roughly how many individual element
moves does that require in total?
ans: Total individual moves = n*(n+1)/2 - (1 + 2 + 3 + 4)
                                = 49*50/2 - 10
                                = 1215
        In every dequeue we need to move count-1 elements. so the number of moves per
        dequeue 49, 48, 47, 46,....
        As we dequeued 45 elements, we do not need to count for last
        4 element's dequeue's move count. Hence, 49*50/2 - 10.

b. You have now written three classes — StudentList, StudentStack, and StudentQueue

— all using the same private array and count. The only real difference is which
methods are available to outside code. In one sentence, explain why hiding the array as
private makes this possible.
ans:Because the array is private, outside code cannot directly modify it.
   This allows each class to enforce different rules (stack or queue)
   while using the same underlying structure.

*/


public class StudentQueue {
    String[] names;
    int[] marks;
    int count;

    //initialize constructor
    StudentQueue(String[] name, int[] mark) {
        this.names = name;
        this.marks = mark;
        this.count = 0;
    }
    public void enqueue(String name,int mark){
        if(count==100){
            System.out.println("ERROR:QUEUE IS FULL");
            return;
        }
        names[count]=name;
        marks[count]=mark;
        count++;

    }
    public void dequeue(){
        if (count == 0) {
            System.out.println("ERROR:QUEUE IS EMPTY");
        return;
        }

        for (int i = 0; i < count - 1; i++) {
            names[i] = names[i + 1];
            marks[i] = marks[i + 1];
        }
        count--;
    }
    public void front(){
        System.out.println("Name:"+names[0]+"Marks"+marks[0]);
    }
   public void display(){
        for(int i=0;i<count;i++){
            System.out.println("Name:"+names[i]+"Marks"+marks[i]);
        }
   }

}