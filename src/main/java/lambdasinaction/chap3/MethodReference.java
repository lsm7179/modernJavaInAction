package lambdasinaction.chap3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReference {

    public static void main(String[] args) {
        List<String> textNumbers = Arrays.asList("0", "1");
        List<Integer> numbers = textNumbers.stream()
                .map(Integer::parseInt)// 메소드 참조(메서드 레퍼런스)
                .collect(Collectors.toList());

        for (Integer number : numbers) {
            System.out.println("number = " + number);
        }

    }
}
/**
 * 메서드 참조는 세가지 유형으로 구분할 수 있다.
 * 1. 정적 메서드 참조
 * 2. 다양한 형식의 인스턴스 메서드 참조
 * 3. 기존 객체의 인스턴스 메서드 참조*/
