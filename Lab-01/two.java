public class two {
    public static void main(String [] args){
        ImaginaryNumber num1 = new ImaginaryNumber();
        String p = num1.printNumber();
        System.out.println(p);
        System.out.println("1********");
        num1.realPart=3;
        num1.imaginaryPart=7;
        num1.SMTH = 10;
        System.out.println(num1.printNumber());
        System.out.println("2********");
        ImaginaryNumber num2 = new ImaginaryNumber();
        num2.realPart=1;
        num2.imaginaryPart=9;
        System.out.println(num2.printNumber());
    }
}


class ImaginaryNumber {
    public static int SMTH = 0;
    private int realPart;               // Visibility: public/private
    public int imaginaryPart;

    // Member Function/Method
    String printNumber() {
        return this.realPart + " + " + this.imaginaryPart + "i" + " SMTH: " + SMTH ;
    }
}


/*

0 + 0i
1********
3 + 7i
2********
1 + 9i

*/