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
}