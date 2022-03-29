package lambdasinaction.chap4;

import java.util.*;
import java.util.stream.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import static lambdasinaction.chap4.Dish.menu;

public class StreamBasic {

    public static void main(String...args){
        // Java 7
        getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

        System.out.println("---");

        // Java 8
        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);

    }

    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes){
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for(Dish d: dishes){ // 누적자로 요소 필터링
            if(d.getCalories() < 400){
                lowCaloricDishes.add(d);
            }
        }
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() { // 익명 클래스로 요리 정렬
            public int compare(Dish d1, Dish d2){
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        for(Dish d: lowCaloricDishes){
            lowCaloricDishesName.add(d.getName()); // 정렬된 리스트를 처리하면서 요리 이름 선택
        }
        return lowCaloricDishesName;
    }

    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes){
        return dishes.stream()
                .filter(d -> d.getCalories() < 400) // 400 칼로리 이하의 요리 선택
                .sorted(comparing(Dish::getCalories)) //칼로리로 요리 정렬
                // .sorted(comparing(Dish::getCalories).reversed()) // 역순 정렬
                .map(Dish::getName)
                .collect(toList());
    }
}
