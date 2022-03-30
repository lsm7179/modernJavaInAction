### 프레디케이트(predicate)란 무엇인가?
인수로 값을 받아 true 나 false를 반환하는 함수를 프레디케이트라고 한다.   
자바8에서는 Predicate<>을 사용하는 것이 더 표준적인 방식이다.

### 3.5.3 형식 추론
자바 컴파일러는 다음처럼 람다 파라미터 형식을 추론할 수 있다.
```text
Comparator<Apple> c = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()); // 형식을 추론하지 않음
Comparator<Apple> c = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight()); // 형식을 추론함
```

## 4.1 스트림이란 무엇인가?
스트림은 자바8에 추가된 기능이다. 스트림을 이용하면 선언형으로 컬렉션 데이터를 처리할 수 있다.   
또한 스트림을 이용하면 멀티스테드 코드를 구현하지 않아도 데이터를 투명하게 병렬로 처리할 수 있다.   
stream() -> parallelStream()으로 바꾸면 병렬로 실행할 수 있다. (7장에 성능이 나옴)   
스트림이란 '데이터 처리 연산을 지원하도록 소스에서 추출된 연속된 요소'로 정의할 수 있다.
