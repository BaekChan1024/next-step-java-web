package calculator.legacy;

/*
* 문제점 : Production Code, Test Code가 한 Class에 공존한다. (서비스하는 시점에서 굳이 같이 배포할 필요가 없다.)
* */
public class Calculator {

    /*
    * Production Code
    * */
    int add(int i, int j) {
        return i + j;
    }

    int subtract(int i, int j) {
        return i - j;
    }

    int multiply(int i, int j) {
        return i * j;
    }

    int divide(int i, int j) {
        return i / j;
    }

    /*
    * Test Code
    * */
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.add(3, 4));
        System.out.println(calculator.subtract(5, 4));
        System.out.println(calculator.multiply(2, 6));
        System.out.println(calculator.divide(8, 4));

    }
}
