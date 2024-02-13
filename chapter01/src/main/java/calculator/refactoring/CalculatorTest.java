package calculator.refactoring;

/*
* Test Code를 분리함으로써 Production Code의 복잡도가 감소한다.
* 문제점: 매번 콘솔로 출력 결과를 사람이 봐야한다.
* */
public class CalculatorTest {
    /*
    * Test Code
    * */
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        add(calculator);
        subtract(calculator);
        multiply(calculator);
        divide(calculator);
    }

    public static void add(Calculator calculator) {
        System.out.println(calculator.add(3, 4));
    }

    public static void subtract(Calculator calculator) {
        System.out.println(calculator.subtract(5, 4));
    }

    public static void multiply(Calculator calculator) {
        System.out.println(calculator.multiply(2, 6));
    }

    public static void divide(Calculator calculator) {
        System.out.println(calculator.divide(8, 4));
    }
}
