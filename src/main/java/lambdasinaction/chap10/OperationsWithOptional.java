package lambdasinaction.chap10;

import static com.hua.jdk8.utils.Print.*;

import java.util.Optional;

/**
 * created at 2019-11-27 17:33
 * @author lerry
 */
public class OperationsWithOptional {
	public static void main(String[] args) {
		createOptional();
	}

	/**
	 * 创建Optional的几种方式
	 */
	public static void createOptional() {
		Optional<Car> optCar = Optional.empty();
		printlnf(optCar);

		Car car = new Car(Optional.ofNullable(new Insurance("中国人寿")));
		Optional<Car> optCar02 = Optional.of(car);
		printlnf(optCar02);

		Optional<Car> optCar03 = Optional.ofNullable(car);
		printlnf(optCar03);

	}
}
