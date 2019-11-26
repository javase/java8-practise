package lambdasinaction.chap6.practise;

import static com.hua.jdk8.utils.Print.*;
import static java.util.stream.Collectors.*;

import java.util.IntSummaryStatistics;

import lambdasinaction.chap6.Dish;

/**
 * created at 2019-11-26 12:43
 * @author lerry
 */
public class CollectorsTest {
	public static void main(String[] args) {
		// 汇总操作
		IntSummaryStatistics statistics = Dish.menu.stream()
				.collect(summarizingInt(Dish::getCalories));
		printlnf(statistics);

		// 连接字符串
		String names = Dish.menu.stream()
				.map(dish -> dish.getName() + ",\t")
				.collect(joining());
		printlnf("菜单名字：%s", names);

		String shortMenu = Dish.menu.stream()
				.map(Dish::getName)
				.collect(joining(",\t"));
		printlnf("菜单名称：%s", shortMenu);

		// 广义的归约
		Dish.menu.stream()
				.collect(
						reducing(
								0, Dish::getCalories, (i, j) -> i + j
						));

		int all = Dish.menu.stream()
				.mapToInt(Dish::getCalories)
				.sum();
		printlnf("总热量：%d", all);
	}
}
