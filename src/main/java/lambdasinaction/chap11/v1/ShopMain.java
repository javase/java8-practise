package lambdasinaction.chap11.v1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * 程序目的：使用CompletableFuture构建异步应用，在客户端进行测试
 * 只有一家商店的情况。在查询这家商店的商品价格时，主线程可以去做其他事情，
 * 也就是异步执行查询价格的方法。
 * </pre>
 * created at 2020/8/13 12:38
 * @author lerry
 */
@Slf4j
public class ShopMain {

	public static void main(String[] args) {
		Shop shop = new Shop("BestShop");
		long start = System.nanoTime();
		Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
		long invocationTime = ((System.nanoTime() - start) / 1_000_000);
		log.info("Invocation returned after {} msecs", invocationTime);

		// Do some more tasks, like querying other shops
		doSomethingElse();
		// while the price of the product is being calculated
		try {
			// 从Future对象中、获取返回值
			double price = futurePrice.get();
			log.info("Price is {}", String.format("%.2f",price));
		}
		catch (ExecutionException | InterruptedException e) {
			throw new RuntimeException(e);
		}

		long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
		log.info("Price returned after {} msecs", retrievalTime);
	}

	private static void doSomethingElse() {
		log.info("Doing something else...");
	}

}/* Output:
2020-08-14 12:44:59.128 [main    ] INFO  ShopMain.java:23 - Invocation returned after 52 msecs
2020-08-14 12:44:59.128 [Thread-0] INFO  Util.java:24 - [delay]1s
2020-08-14 12:44:59.132 [main    ] INFO  ShopMain.java:42 - Doing something else...
2020-08-14 12:45:00.142 [main    ] INFO  ShopMain.java:31 - Price is 123.26
2020-08-14 12:45:00.143 [main    ] INFO  ShopMain.java:38 - Price returned after 1069 msecs
 *///:~
