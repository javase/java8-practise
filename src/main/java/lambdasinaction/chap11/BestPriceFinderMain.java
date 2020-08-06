package lambdasinaction.chap11;

import static com.hua.jdk8.utils.Print.*;

import java.util.List;
import java.util.function.Supplier;

public class BestPriceFinderMain {

	private static BestPriceFinder bestPriceFinder = new BestPriceFinder();

	public static void main(String[] args) {
		// 初始化足够数量的shop对象，以便进行性能测试
		bestPriceFinder.initShops(50);
		execute("sequential", () -> bestPriceFinder.findPricesSequential("myPhone27S"));
		printALineDouble();
		execute("parallel", () -> bestPriceFinder.findPricesParallel("myPhone27S"));
		printALineDouble();
		execute("composed CompletableFuture", () -> bestPriceFinder.findPricesFuture("myPhone27S"));
		printALineDouble();
		bestPriceFinder.printPricesStream("myPhone27S");
		printALineDouble();
	}

	private static void execute(String msg, Supplier<List<String>> s) {
		long start = System.nanoTime();
		System.out.println(s.get());
		long duration = (System.nanoTime() - start) / 1_000_000;
		System.out.println(msg + " done in " + duration + " msecs");
	}

}
