package lambdasinaction.chap5.practise;

import static com.hua.jdk8.utils.Print.*;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 勾股数的练习
 * 练习流的各种强大功能
 * created at 2019-11-25 17:21
 * @author lerry
 */
public class Pythagorean {
	public static void main(String[] args) {
		IntStream.rangeClosed(1, 100)
				.forEach(obj -> printf("%s,", obj));
		printALine();

		// 勾股数
		Stream<int[]> pythagoreanTriples =
				IntStream.rangeClosed(1, 100)
						.boxed()
						.flatMap(a ->
								IntStream.rangeClosed(a, 100)
										.filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
										.mapToObj(b ->
												new int[] {a, b, (int) Math.sqrt(a * a + b * b)})
						);

	/*
	 new int[]{3,4,5} 可以用来表示勾股数
	 a * a + b * b的平方根 应该是整数
	 */
		pythagoreanTriples
				.limit(500)
				.forEach(t -> printlnf("%s,%s,%s", t[0], t[1], t[2]));

		printALine();

		printlnf("生成对象的测试  mapToObj");
		IntStream.rangeClosed(1, 3)
				.mapToObj(b -> new int[] {b, b * b, b + 1})
				.forEach(obj -> printlnf("数组的值为：%s,%s,%s", obj[0], obj[1], obj[2]));

		printlnf("整数的测试：");
		IntStream.rangeClosed(1, 10)
				.filter(i -> Math.sqrt(i) % 1 == 0)
				.forEach(obj -> printlnf("平方根为整数的有：%s", obj));

		printlnf("%s %%1 = %s", 2.1, 2.1 % 1);
	}
}
