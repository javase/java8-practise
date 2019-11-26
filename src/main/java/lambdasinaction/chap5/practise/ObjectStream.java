package lambdasinaction.chap5.practise;

import static com.hua.jdk8.utils.Print.*;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import lambdasinaction.chap4.Dish;

/**
 * 对象流  转为包装类型的流
 * created at 2019-11-25 17:16
 * @author lerry
 */
public class ObjectStream {

	public static void main(String[] args) {
		IntStream intStream = Dish.menu.stream()
				.mapToInt(Dish::getCalories);

		// 数值流转为对象流  转为包装类型 java.lang.Integer
		Stream stream = intStream.boxed();

		stream.forEach(obj -> printlnf("对象的getClass:%s，对象的值：%s", obj.getClass(), obj));

	}
}
