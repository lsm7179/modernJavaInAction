package lambdasinaction.chap10;

import java.util.*;

import static java.util.stream.Collectors.toSet;

public class OptionalMain {

    public String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
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
