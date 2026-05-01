public class StudentStack {
    private String[] name = new String[100];
    private int[] marks = new int[100];
    private int count = 0;
    public void push(String name, int marks){
        if(cout==100){
            Suystem.out.println("Stack is full");
            return;
            this.name[count]=name;
            this.marks[count]=marks;
            cout++;
        }
    }
}
