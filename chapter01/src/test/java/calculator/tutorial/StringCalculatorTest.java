package calculator.tutorial;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;


import static org.junit.jupiter.api.Assertions.*;

/*
 * 작은 요구사항 기준으로 유닛 테스트 진행할 것
 * 1. 빈 문자열일 경우 -> 0
 * 2. 숫자가 하나일 경우 -> 숫자
 * 3. 쉼표 구분자가 있을 경우 -> 숫자의 합
 * 4. 쉼표 또는 클론 구분자가 있을 경우 -> 숫자의 합
 * 5. // 또는 \n 문자 사이의 커스텀 구분자 지정 -> 숫자의 합
 * 6. 음수를 전달하는 경우 -> runtimeException
 * */
class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("빈 문자열일 경우")
    public void nullOrEmpty() {
        assertEquals(stringCalculator.add(""), 0);
        assertEquals(stringCalculator.add(null), 0);
    }

    @Test
    @DisplayName("숫자가 하나일 경우")
    public void onlyNumber() {
        assertEquals(stringCalculator.add("1"), 1);
        assertEquals(stringCalculator.add("3"), 3);
    }

    @Test
    @DisplayName("쉼표 구분자가 있을 경우")
    public void oneDelimiter() {
        assertEquals(stringCalculator.add("1,2"), 3);
    }

    @Test
    @DisplayName("쉼표 또는 클론 구분자가 있을 경우")
    public void twoDelimiter() {
        assertEquals(stringCalculator.add("1,2:3"), 6);
    }

    @Test
    @DisplayName("// 또는 \\n 문자 사이의 커스텀 구분자 지정")
    public void customDelimiter() {
        assertEquals(stringCalculator.add("//;\n1;2;3"), 6);
    }

    @Test
    @DisplayName("음수를 전달하는 경우")
    public void addNegative() {
        assertThrows(RuntimeException.class, () -> stringCalculator.add("-1,2,3"));
    }

//    @Test
//    public void add() {
//        assertEquals(stringCalculator.add("//;\n1;2;3"), 6);
//    }

}