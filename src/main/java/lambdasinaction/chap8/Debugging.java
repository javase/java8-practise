package lambdasinaction.chap8;


import static com.hua.jdk8.utils.Print.*;

import java.util.Arrays;
import java.util.List;

/**
 * 故意让Lambda表达式报错，来查看堆栈信息
 */
public class Debugging {
	public static void main(String[] args) {
		List<Point> points = Arrays.asList(new Point(12, 2), null);
		try {
			points.stream()
					.map(p -> p.getX())
					.forEach(System.out::println);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		try {
			List<Integer> numbers = Arrays.asList(1, 2, 3);
			numbers.stream()
					.map(Debugging::devideByZero)
					.forEach(System.out::println);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		List<Integer> numbers02 = Arrays.asList(2, 3, 4, 5);
		numbers02.stream()
				.map(x -> x + 17)
				.filter(x -> x % 2 == 0)
				.limit(3)
				.forEach(System.out::println);

		numbers02.stream()
				.peek(x -> printlnf("from stream:%s", x))
				.map(x -> x + 17)
				.peek(x -> printlnf("after map:%s", x))
				.filter(x -> x % 2 == 0)
				.peek(x -> printlnf("after filter:%s", x))
				.limit(3)
				.peek(x -> printlnf("after limit:%s", x))
				.forEach(System.out::println);
	}

	public static int devideByZero(int n) {
		return n / 0;
	}

	private static class Point {
		private int x;

		private int y;

		private Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}
	}
}
