package lambdasinaction.chap11.v1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ShopMain {

	public static void main(String[] args) {
		Shop shop = new Shop("BestShop");
		long start = System.nanoTime();
		 Future<Double> futurePrice = shop.getPriceAsyncWithEx("my favorite product");
//		Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
		long invocationTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("Invocation returned after " + invocationTime
				+ " msecs");

		// Do some more tasks, like querying other shops
		doSomethingElse();
		// while the price of the product is being calculated
		try {
			// 从Future对象中、获取返回值
			double price = futurePrice.get(1, TimeUnit.MILLISECONDS);
			System.out.printf("Price is %.2f%n", price);
		}
		catch (ExecutionException | InterruptedException e) {
			throw new RuntimeException(e);
		}
		catch (TimeoutException e) {
			e.printStackTrace();
		}
		long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("Price returned after " + retrievalTime + " msecs");
	}

	private static void doSomethingElse() {
		System.out.println("Doing something else...");
	}

}
