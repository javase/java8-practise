package lambdasinaction.chap11.v1;

import static lambdasinaction.chap11.Util.*;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {

	private final String name;

	private final Random random;

	public Shop(String name) {
		this.name = name;
		random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
	}

	public double getPrice(String product) {
		return calculatePrice(product);
	}

	/**
	 * 计算价格
	 * @param product
	 * @return
	 */
	private double calculatePrice(String product) {
		delay();
		return random.nextDouble() * product.charAt(0) + product.charAt(1);
	}

	/**
	 * 异步获取商品价格
	 * @param product
	 * @return
	 */
	public Future<Double> getPriceAsync(String product) {
		// 包含计算的结果
		CompletableFuture<Double> futurePrice = new CompletableFuture<>();
		new Thread(() -> {
			// 在新的线程中，异步执行计算方法
			double price = calculatePrice(product);
			// 需要长时间计算的任务结束并得出结果时，设置Future的返回值
			futurePrice.complete(price);
		}).start();
		// 无需等待还没结束的计算，直接返回Future对象
		return futurePrice;
	}

	public Future<Double> getPriceAsyncWithEx(String product) {
		CompletableFuture<Double> futurePrice = new CompletableFuture();
		new Thread(() -> {
			try {
				double price = calculatePrice(product);
				futurePrice.complete(price);
			}
			catch (Exception e) {
				futurePrice.completeExceptionally(e);
			}
		}).start();
		return futurePrice;
	}

	public String getName() {
		return name;
	}

}
