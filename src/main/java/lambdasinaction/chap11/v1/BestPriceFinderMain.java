package lambdasinaction.chap11.v1;

import static com.hua.jdk8.utils.Print.*;

import java.util.List;
import java.util.function.Supplier;

public class BestPriceFinderMain {

	private static BestPriceFinder bestPriceFinder = new BestPriceFinder();

	public static void main(String[] args) {
		printlnf("本机CPU核心个数为:%d", Runtime.getRuntime().availableProcessors());
		printlnf("商店数量为：%d", bestPriceFinder.getShops().size());

//		execute("sequential", () -> bestPriceFinder.findPricesSequential("myPhone27S"));
		execute("parallel", () -> bestPriceFinder.findPricesParallel("myPhone27S"));
		execute("composed CompletableFuture", () -> bestPriceFinder.findPricesFuture("myPhone27S"));
		execute("combined USD CompletableFuture", () -> bestPriceFinder.findPricesInUSD("myPhone27S"));
		execute("combined USD CompletableFuture v2", () -> bestPriceFinder.findPricesInUSD2("myPhone27S"));
		execute("combined USD CompletableFuture v3", () -> bestPriceFinder.findPricesInUSD3("myPhone27S"));
	}

	private static void execute(String msg, Supplier<List<String>> s) {
		long start = System.nanoTime();
		System.out.println(s.get());
		long duration = (System.nanoTime() - start) / 1_000_000;
		System.out.println(msg + " done in " + duration + " msecs\n\n");
	}
}
