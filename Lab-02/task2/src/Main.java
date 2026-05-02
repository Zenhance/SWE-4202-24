public class Main {
 public static void main(String[] args){
     StudentStack stack = new StudentStack();
     stack.push("Farnaz",100);
     stack.push("Rahman",100);
     stack.push("abc",67);
     stack.push("def",67);
     stack.push("ghi",67);

     stack.peek();
     stack.pop();
     stack.pop();
     stack.pop();
     stack.display();





 }
}
