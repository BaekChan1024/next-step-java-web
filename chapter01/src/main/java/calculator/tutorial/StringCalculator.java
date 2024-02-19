package calculator.tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    // 구현 TDD 적용 X
//    public int add(String input) {
//        return Arrays.stream(input.split("[^0-9]")).filter(e -> !e.isEmpty()).mapToInt(Integer::parseInt).sum();
//    }

//    // 책 TDD 적용 X
//    public int add(String input) {
//        if (Objects.isNull(input)) {
//            return 0;
//        }
//        if (input.isEmpty()) {
//            return 0;
//        }
//
//        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
//        List<String> stringList = new ArrayList<>();
//        if (m.find()) {
//            String customDelimeter = m.group(1);
//            String[] tokens = m.group(2).split(customDelimeter);
//            stringList = Arrays.stream(tokens).toList();
//        }
//        return stringList.stream().filter(e -> !e.isEmpty()).mapToInt(Integer::parseInt).sum();
//    }

    // 1차 TDD 작성
    // 문제점 : 이미 작성된 구현 바디를 건들지말자.... return 대한 비즈니스 로직을 건들다보니 메서드의 변경이 일어나서 사이드 임펙트 가능성이 생긴다.
//    public int add(String input) {
//        if (Objects.isNull(input) || input.isEmpty()) {
//            return 0;
//        }
//        return Arrays.stream(input.split(",|;")).mapToInt(Integer::parseInt).sum();
//    }

    public int add(String input) {
        if (this.isBlank(input)) {
            return 0;
        }
        return sum(toInts(split(input)));
    }

    private boolean isBlank(String input) {
        return Objects.isNull(input) || input.isEmpty();
    }

    /*
    * 구분자 기준으로 문자열 배열을 만드는 일
    * */
    private String[] split(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String custom = m.group(1);
            return m.group(2).split(custom);
        }
        return input.split(",|:");
    }

    /*
    * 문자열 배열 -> 숫자형 배열
    * */
    private int[] toInts(String[] values) {
        return Arrays.stream(values).mapToInt(this::toInt).toArray();
    }

    /*
    * 문자열 -> 숫자형
    * */
    private int toInt(String value) {
        int i = Integer.parseInt(value);
        if (i < 0) {
            throw new RuntimeException();
        }
        return i;
    }

    /*
    * 숫자형 배열의 합
    * */
    private int sum(int[] values) {
        return Arrays.stream(values).sum();
    }



}
