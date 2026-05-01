public class StudentStack {
    private String[] name;
    private int[] marks;
    private int c;


    StudentStack(String name, int marks)
    {
        this.name=name;
        this.marks=marks;
        this.c=0;
    }
    public void push(String name, int marks) {
        if (c>=10) {
            System.out.println("stack is full.");
            return;
        }
        names[c] = name;
        marks[c] = marks;
        c++;
    }

    public void pop() {
        if (c==0){
            System.out.println("Error: The stack is empty.");
            return;
        }
        int topIndex=c-1;
        System.out.println("Popped: "+names[topIndex]+" ("+marks[topIndex]+")");

        c--;
    }

    public void peek() {
        if (c==0){
            System.out.println("Stack is empty.");
        }
        System.out.println(names[c-1]+" ("+marks[c-1]+")");
    }

    public void display() {
        for (int i=0;i<c;i++) {
            System.out.println(i+": "+names[i]+" - "+marks[i]);
        }
    }

    public static void main(String[] args) {
        StudentStack stack = new StudentStack();
        stack.push("Alice", 85);
        stack.push("Bob", 72);
        stack.push("Charlie", 90);
        stack.push("Diana", 88);
        stack.push("Edward", 95);
        stack.peek();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.display();
    }
}
 