package study;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamTest {
    @Test
    public void takeWhileTest() {

        List<Integer> list = Arrays.asList(1, 2, 10, 5, 6, 4, 7, 7);

        List<Integer> sliceList = list.stream()
                .takeWhile(number -> number < 5)
                .collect(toList());

        Optional<Integer> first = list.stream()
                .takeWhile(number -> number < 5)
                .findFirst();

        Integer integer = first.orElse(0);
        System.out.println(integer);


       /* System.out.println(sliceList);

        List<Integer> list1 = sliceList.stream()
                .skip(5)
                .collect(Collectors.toList());
        System.out.println(list1);*/
    }

    @Test
    public void nullStream() {

        Stream<String> stream = Stream.of("Modern", "Java", "In", "Action", null);

        List<String> list = stream.collect(toList());
        System.out.println(list);
    }

    @Test
    public void flatMapTest() {
        List<String> words = Arrays.asList("hello","world");

        List<String> oneWords = null; //중복제거도 하고 싶었음.

        words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(toList()); // X List<String[]>

        words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList());

        words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .collect(toList());
    }
}
