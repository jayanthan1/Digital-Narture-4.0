public class Calculator {
    private int result;
    
    public Calculator() {
        this.result = 0;
    }
    
    public int add(int a, int b) {
        result = a + b;
        return result;
    }
    
    public int subtract(int a, int b) {
        result = a - b;
        return result;
    }
    
    public int multiply(int a, int b) {
        result = a * b;
        return result;
    }
    
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        result = a / b;
        return result;
    }
    
    public int getResult() {
        return result;
    }
    
    public void reset() {
        result = 0;
    }
}
