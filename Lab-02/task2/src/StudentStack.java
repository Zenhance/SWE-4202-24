public class StudentStack {
    private String[] name = new String[100];
    private int[] marks = new int[100];
    private int count = 0;
    public void push(String name, int marks){
        if(cout==100){
            Suystem.out.println("Stack is full");
            return;
            }
            this.name[count]=name;
            this.marks[count]=marks;
            cout++;

    }
    public void pop(){
        if (count == 0) {
            System.out.println("Stack is empty");
            return;
        }
        count--;
        System.out.println("Name:" +this.name[count] + " Marks: " + this.marks[count]);
    }
    public void peek(){
       System.out.println("Name: "+this.name[count-1]);
    }
}
