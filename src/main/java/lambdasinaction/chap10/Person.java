package lambdasinaction.chap10;

import java.util.Optional;

public class Person {
    public Person(Optional<Car> car) {
        this.car = car;
    }

    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }
}
