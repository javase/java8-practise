package lambdasinaction.chap10;

import static com.hua.jdk8.utils.Print.*;

import java.util.Optional;

public class OptionalMain {


	public static void main(String[] args) {
		System.out.println(System.nanoTime());
		System.out.println(System.currentTimeMillis());
		Insurance insurance = new Insurance("中国人寿");
		Car car = new Car(Optional.of(insurance));
		Person person = new Person(Optional.of(car));

		Optional<Insurance> optInsurance = Optional.ofNullable(insurance);

		// 使用map函数，来获取Insurance对象中的名字
		Optional<String> name = optInsurance.map(Insurance::getName);
		printlnf(name);

		// 使用flatMap函数，去多层获取属性值
		Optional<Person> optPerson = Optional.of(person);
		String nameInCar = getCarInsuranceName(optPerson);
		printlnf(nameInCar);

		printlnf("Optional.empty().isPresent():%s", Optional.empty().isPresent());

	}

	public static String getCarInsuranceName(Optional<Person> person) {
		return person.flatMap(Person::getCar)
				.flatMap(Car::getInsurance)
				.map(Insurance::getName)
				.orElse("Unknown");
	}

}