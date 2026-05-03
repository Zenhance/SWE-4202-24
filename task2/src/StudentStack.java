public class StudentStack {
    String[] name;
    float[] mark;
    int students=1000;
    int count=0;

    StudentStack() {
        this.name=name;
        this.mark=mark;
    }
    public void push(String[] name, float[] mark) {
        if(count==students) {
            System.out.println("The Stack is full");
        }

        this.name=name;
        this.mark=mark;
        count++;
    }

    public void pop() {
        if(count==0) {
            System.out.println("The stack is empty");
        }

        System.out.println(this.name[count]);
        System.out.println(this.mark[count]);
        count--;
    }

    public void peek() {
        System.out.println(this.name[count]);
    }
}