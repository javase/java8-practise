package lambdasinaction.chap5.practise;

import java.util.stream.Stream;

/**
 * <pre>
 * 程序目的：数组转Stream，然后求和
 * </pre>
 * created at 2020/8/13 09:51
 * @author lerry
 */
public class ArrayStreamSum {
	public static void main(String[] args) {
		Double[] hours = {2d,
				1.5,
				4d,
				2d,
				3.5,
				2d,
				3.5,
				3.5,
				3.5,
				6d};
		Double sum = Stream.of(hours).mapToDouble((x) -> x).sum();
		System.out.printf("数组求和结果为：%s", sum);
	}
}
