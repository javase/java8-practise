package lambdasinaction.chap8;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

import java.util.Comparator;
import java.util.List;

/**
 * 位置类
 */
public class Point {
	private final int x;

	private final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Point moveRightBy(int x) {
		return new Point(this.x + x, this.y);
	}

	/**
	 * 用于对Lambda表达式的测试
	 */
	public final static Comparator<Point> compareByXAndThenY = comparing(Point::getX).thenComparing(Point::getY);

	public static List<Point> moveAllPointsRightBy(List<Point> points, int x) {
		return points.stream()
				.map(p -> new Point(p.getX() + x, p.getY()))
				.collect(toList());
	}

	@Override
	public String toString() {
		return String.format("x is :%d,y is %d", this.getX(), this.getY());
	}
}