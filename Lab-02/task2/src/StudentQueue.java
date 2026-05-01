public class StudentQueue {
    private String[] name = new String[100];
    private int[] marks = new int[100];
    private int count = 0;
    public void enqueue(String name,int marks){
        if(count==100){
            System.out.println("Stack is full");
            return;
        }
        this.name[count]=name;
        this.marks[count]=marks;
        count++;
    }
    public void dequeue(){
        if(count==0){
            System.out.println("The queue is empty.");
            return;
        }
        System.out.println("Name: "+this.name[0]+" Mark: "+this.marks[0]);
        for (int i = 0; i < count-1; i++){
            this.name[i] = this.name[i+1];
            this.marks[i] = this.marks[i+1];
        }
        count--;
    }
    public void front(){
        System.out.println("Name: "+this.name[0] + " Mark:" + this.marks[0]);
    }
}
