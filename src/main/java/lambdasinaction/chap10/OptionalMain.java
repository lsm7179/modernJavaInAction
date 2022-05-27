package lambdasinaction.chap10;

import java.util.*;

import static java.util.stream.Collectors.toSet;

public class OptionalMain {
    public static void main(String[] args) {
        Car car = new Car("아반떼");

        Optional<Car> optCar = Optional.ofNullable(car);

        Car 차량꺼냄 = optCar.orElse(getCar());
        System.out.println(차량꺼냄.getName());
        optCar.orElseGet(() -> orElseGetCar());


        Optional opt = Optional.empty();
        opt.orElse(new Object());
    }

    private static Car getCar() {
        System.out.println("이친구는 값이 있어도 실행되요.");
        return new Car();
    }

    private static Car orElseGetCar() {
        System.out.println("이친구는 값이 있으면 실행 안되요.");
        return new Car();
    }

    public String getCarInsuranceName(Optional<Person> optPerson) {

        /*Optional<String> name = optPerson.map(Person::getCar)
                .map(Car::getInsurance)
                .map(Insurance::getName);*/

        return optPerson.flatMap(Person::getCar)
                     .flatMap(Car::getInsurance)
                     .map(Insurance::getName)
                     .orElse("Unknown");
    }

    public Set<String> getCarInsuranceNames(List<Person> persons) {
        return persons.stream()
                      .map(Person::getCar)
                      .map(optCar -> optCar.flatMap(Car::getInsurance))
                      .map(optInsurance -> optInsurance.map(Insurance::getName))
                      .flatMap(Optional::stream)
                      .collect(toSet());
    }

    public String sumString(String a, String b){
        return a+b;
    }

    public Optional<String> sumOptString(){
        Optional<String> nicky = Optional.of("이승민");
        Optional<String> lucky = Optional.of("운이좋네");

        return nicky.flatMap(n -> lucky.map(l -> sumString(n,l)));
    }


}
