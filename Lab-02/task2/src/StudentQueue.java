public class StudentQueue {
    private String[] names;
    private int[] marks;
    private int count;

    public StudentQueue(int size) {
        names = new String[size];
        marks = new int[size];
        count = 0;
    }

    public void enqueue(String name, int mark) {
        if (count == names.length) {
            System.out.println("Queue is full");
            return;
        }
            names[count] = name;
            marks[count] = mark;
            count++;

    }
    public void dequeue() {
        if(count == 0){
            System.out.println("Queue is empty");
            return ;
    }
        System.out.println("Removed:"+names[0]+" "+marks[0]);
        for(int i = 0; i < count-1; i++){
        names[i] = names[i+1];
            marks[i] = marks[i+1];
        }
        count--;
    }
    public void front(){
        System.out.println("Front:"+names[0]+" "+marks[0]);
    }
    public void display(){
        for(int i = 0; i < count; i++){
            System.out.print(names[i]+" "+marks[i]);
        }
    }
}

