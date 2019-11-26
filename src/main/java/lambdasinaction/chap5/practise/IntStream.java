package lambdasinaction.chap5.practise;

import static com.hua.jdk8.utils.Print.*;

import lambdasinaction.chap4.Dish;

/**
 * 数值流
 * created at 2019-11-25 17:12
 * @author lerry
 */
public class IntStream {

	public static void main(String[] args) {
		int sum = Dish.menu.stream()
				// IntStream
				.mapToInt(Dish::getCalories)
				.sum();
		printlnf("数值流汇总：%s", sum);

	}
}
