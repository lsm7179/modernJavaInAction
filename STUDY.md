### 프레디케이트(predicate)란 무엇인가?
인수로 값을 받아 true 나 false를 반환하는 함수를 프레디케이트라고 한다.   
자바8에서는 Predicate<>을 사용하는 것이 더 표준적인 방식이다.

### 3.5.3 형식 추론
자바 컴파일러는 다음처럼 람다 파라미터 형식을 추론할 수 있다.
```text
Comparator<Apple> c = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()); // 형식을 추론하지 않음
Comparator<Apple> c = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight()); // 형식을 추론함
```