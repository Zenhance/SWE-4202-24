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

}
