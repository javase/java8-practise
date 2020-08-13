package lambdasinaction.chap11.v1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * 程序目的：使用CompletableFuture构建异步应用，在客户端进行测试
 * </pre>
 * created at 2020/8/13 12:38
 * @author lerry
 */
@Slf4j
public class ShopMain {

	public static void main(String[] args) {
		Shop shop = new Shop("BestShop");
		long start = System.nanoTime();
		// Future<Double> futurePrice = shop.getPriceAsyncWithEx("my favorite product");
		Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
		long invocationTime = ((System.nanoTime() - start) / 1_000_000);
		log.info("Invocation returned after {} msecs", invocationTime);

		// Do some more tasks, like querying other shops
		doSomethingElse();
		// while the price of the product is being calculated
		try {
			// 从Future对象中、获取返回值
//			double price = futurePrice.get(1, TimeUnit.MILLISECONDS);
			double price = futurePrice.get();
			log.info("Price is {}", price);
		}
		catch (ExecutionException | InterruptedException e) {
			throw new RuntimeException(e);
		}
//		catch (TimeoutException e) {
//			e.printStackTrace();
//		}
		long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
		log.info("Price returned after {} msecs", retrievalTime);
	}

	private static void doSomethingElse() {
		log.info("Doing something else...");
	}

}
