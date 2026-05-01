public class StudentStack {
    private Student[] students = new Student[50];
    private int count = 0;

    public void push(String name,int mark) {
        if (count == students.length) {
            System.out.println("Stack is full");
            return;
        }
        students[count] = new Student(name, mark);
        count++;
    }
    public void pop(){
    if (count==0){
        System.out.println("Stack is empty");
        return;
    }
    System.out.println("popped: ");
    students[count-1].display();
    count--;
    }
    public void peek() {
        if (count == 0) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("top elements: ");
        students[count - 1].display();
    }
}