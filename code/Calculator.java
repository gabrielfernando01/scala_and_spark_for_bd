
public class Calculator {

    // Static method
    public static int sum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        // Calling a static method without creating an object
        int result = Calculator.sum(8, 2);
        System.out.println("The sum is: " + result);
    }
}


