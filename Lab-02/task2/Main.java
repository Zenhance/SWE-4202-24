public class Main{
    public static void main(){
        String[] names=new String[500];
        double[] marks=new double[500];

        System.out.println("Student Stack:");
        StudentStack stack=new StudentStack(name,marks);

        stack.push("A",80);
        stack.push("B",90);
        stack.push("C",80);
        stack.push("D",90);
        stack.push("E",80);

        stack.peek();
        stack.pop();
    stack.pop();





    }
}