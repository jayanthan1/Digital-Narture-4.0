public class BytecodeExample {
    private int number;
    private String message;

    public BytecodeExample(int number, String message) {
        this.number = number;
        this.message = message;
    }

    public int addNumbers(int a, int b) {
        return a + b;
    }

    public String repeatMessage(int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(message);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BytecodeExample example = new BytecodeExample(42, "Hello");
        int sum = example.addNumbers(10, 20);
        String repeated = example.repeatMessage(3);
        System.out.println("Sum: " + sum);
        System.out.println("Repeated: " + repeated);
    }
}
