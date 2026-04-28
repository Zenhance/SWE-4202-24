public class StudentStack {
    private String[] name = new String[50];
    private int[] marks = new int[50];
    private int count = 0;

    public void push(String name, int marks) {
        if (count + 1 > 50){
            System.out.println("Stack is full");
            return;
        }
        this.name[count] = name;
        this.marks[count] = marks;
        count++;
    }

    public void pop(){
        if (count - 1 < 0) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println(this.name[count-1] + " " + this.marks[count-1]);
        this.name[count-1] = null;
        this.marks[count-1] = 0;
        count--;
    }
}
