package lambdasinaction.chap8;

import static com.hua.jdk8.utils.Print.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * created at 2019-11-27 13:39
 * @author lerry
 */
public class PointTest {

	@Test
	public void testMoveRightBy() throws Exception {
		Point p1 = new Point(5, 5);
		Point p2 = p1.moveRightBy(10);
		printlnf("位置P2的X坐标：%s", p2.getX());
		printlnf("位置P2的Y坐标：%s", p2.getY());

	}

	@Test
	public void testComparingTwoPoints() throws Exception {
		Point p1 = new Point(10, 15);
		Point p2 = new Point(10, 20);
		Point p3 = new Point(10, 15);
		int result = Point.compareByXAndThenY.compare(p1, p2);
		printlnf(result);

		int result2 = Point.compareByXAndThenY.compare(p1, p3);
		printlnf(result2);
	}

	@Test
	public void testMoveAllPointsRightBy() throws Exception {
		List<Point> points = Arrays.asList(new Point(5, 5), new Point(10, 5));
		List<Point> expectedPoints = Arrays.asList(new Point(15, 5), new Point(20, 5));

		List<Point> newPoints = Point.moveAllPointsRightBy(points, 10);
		newPoints.forEach(System.out::println);

		printlnf("期望的位置为：");
		expectedPoints.forEach(System.out::println);
	}
}
