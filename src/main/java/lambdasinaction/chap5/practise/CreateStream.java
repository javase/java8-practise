package lambdasinaction.chap5.practise;

import static com.hua.jdk8.utils.Print.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 创建流的各种方式
 * created at 2019-11-25 17:49
 * @author lerry
 */
public class CreateStream {
	public static void main(String[] args) {
		// 由值创建流
		List list = Stream.of("Java 8 ", "Lambdas ", "In ", "Action")
				.collect(Collectors.toList());
		printlnf(list);

		// 由数组创建
		int[] numbers = {2, 3, 4, 5, 6};
		Arrays.stream(numbers);

		// 由文件创建流
		Path path = Paths.get("src/main/resources/lambdasinaction/chap5/data.txt");
		long uniqueWords = 0;
		try (Stream<String> lines = Files.lines(path, Charset.defaultCharset())) {
			uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
					.distinct()
					.count();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		printlnf("不重复的词有%d个", uniqueWords);


		// 创建无限流
		printlnf("创建无限流:");
		Stream.iterate(0, n -> n + 2)
				.limit(10)
				.forEach(System.out::println);

		printlnf("斐波那契数列：");
		// 斐波那契数列
		Stream.iterate(new int[] {0, 1},
				t -> new int[] {t[1], t[0] + t[1]})
				.limit(20)
				.map(t -> t[0])
				.forEach(System.out::println);

		printlnf("生成5个随机数：");
		Stream.generate(() -> Math.random())
				.limit(5)
				.forEach(System.out::println);

		printlnf("生成一个全是1的无限流：");
		IntStream ones = IntStream.generate(()->1);

		printlnf("匿名类可以通过字段定义状态，而状态又可以用getAsInt方法来修改。这是一个副作用的例子。");
		IntStream twos = IntStream.generate(new IntSupplier() {
			@Override
			public int getAsInt() {
				return 2;
			}
		});
	}
}
