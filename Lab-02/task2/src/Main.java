public class Main{
    public static void main(String[] args){
        String[] names = new String[100];
        int[] marks = new int[100];

        StudentStack stack = new StudentStack(names, marks);

        stack.push("Alice",100);
        stack.push("Bob",90);
        stack.push("Jenny",80);
        stack.push("Clinton",70);
        stack.push("Fred",85);

        stack.peek();

        stack.pop();
        stack.pop();
        stack.pop();

        stack.display();

    }
}
