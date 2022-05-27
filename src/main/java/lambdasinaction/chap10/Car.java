package lambdasinaction.chap10;

import java.util.*;

public class Car {

    private Optional<Insurance> insurance;

    private String name;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }

    public Car(Optional<Insurance> insurance) {
        this.insurance = insurance;
    }

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
