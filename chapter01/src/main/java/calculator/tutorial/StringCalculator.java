package calculator.tutorial;

import java.util.Arrays;

public class StringCalculator {

    public int add(String input) {
        return Arrays.stream(input.split("[^0-9]")).filter(e -> !e.isEmpty()).mapToInt(Integer::parseInt).sum();
    }
}
