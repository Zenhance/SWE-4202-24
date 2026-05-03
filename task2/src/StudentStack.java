public class StudentStack {
    String[] name;
    float[] mark;
    int students=1000;
    int count=0;

    public void push(String[] name, float[] mark) {
        if(count==students) {
            System.out.println("The Stack is full");
        }

        this.name=name;
        this.mark=mark;
        count++;
    }
}