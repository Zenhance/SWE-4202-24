public class StudentQueue {
    private String[] name = new String[100];
    private int[] marks = new int[100];
    private int count = 0;
    public void enqueue(String name,int marks){
        if(count==100){
            System.out.println("Stack is full");
        }
        this.name[count]=name;
        this.marks[count]=marks;
        count++;
    }
}
