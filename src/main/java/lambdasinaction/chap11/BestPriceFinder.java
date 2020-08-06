package lambdasinaction.chap11;

import static com.hua.jdk8.utils.Print.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.hua.jdk8.utils.Print;

public class BestPriceFinder {

	private List<Shop> shops =
			Arrays.asList(new Shop("BestPrice"),
					new Shop("LetsSaveBig"),
					new Shop("MyFavoriteShop"),
					new Shop("BuyItAll"),
					new Shop("ShopEasy"));

	/**
	 * 添加足够数量的shop对象，以便进行性能测试
	 * @param size
	 */
	public void initShops(int size) {
		int shopCount = shops.size();
		if (size <= shopCount) {
			return;
		}

		List<Shop> shopNewList = new ArrayList<>();
		for (int i = 0; i < size - shopCount; i++) {
			Shop shop = new Shop("BestPrice");
			shopNewList.add(shop);
		}
		shopNewList.addAll(shops);

		shops = shopNewList;

	}

	private final Executor executor = Executors.newFixedThreadPool(shops.size(), new ThreadFactory() {
		@Override
		public Thread newThread(Runnable r) {
			Thread t = new Thread(r);
			t.setDaemon(true);
			return t;
		}
	});

	/**
	 * 串行的方式进行价格计算
	 * @param product
	 * @return
	 */
	public List<String> findPricesSequential(String product) {
		return shops.stream()
				.peek(shop -> printlnf("[shop.getPrice]\tproduct is [%s],获取价格：[%s]", product, shop.getPrice(product)))
				.map(shop -> shop.getPrice(product))
				.peek(str -> printlnf("[Quote.parse]\tgetPrice is [%s],parse 后，转为Quote对象:[%s]", str, Quote.parse(str)))
				.map(Quote::parse)
				.peek(quote -> printlnf("[Discount.applyDiscount]\tapplyDiscount后：[%s]", Discount.applyDiscount(quote)))
				.map(Discount::applyDiscount)
				.peek(e -> Print.printALine())
				.collect(Collectors.toList());
	}

	/**
	 * 并行方式进行
	 * @param product
	 * @return
	 */
	public List<String> findPricesParallel(String product) {
		return shops.parallelStream()
				.map(shop -> shop.getPrice(product))
				.map(Quote::parse)
				.map(Discount::applyDiscount)
				.collect(Collectors.toList());
	}

	public List<String> findPricesFuture(String product) {
		List<CompletableFuture<String>> priceFutures = findPricesStream(product)
				.collect(Collectors.<CompletableFuture<String>>toList());

		return priceFutures.stream()
				.map(CompletableFuture::join)
				.collect(Collectors.toList());
	}

	/**
	 * 返回一个由Future构成的流
	 * @param product
	 * @return
	 */
	public Stream<CompletableFuture<String>> findPricesStream(String product) {
//		return shops.stream()
//				.map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor))
//				.map(future -> future.thenApply(Quote::parse))
//				.map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)));

		Stream<CompletableFuture<String>> completableFutureStream = shops.stream()
				.map(shop -> CompletableFuture.supplyAsync(
						() -> shop.getPrice(product), executor
				)).map(future -> future.thenApply(Quote::parse))
				.map(future -> future.thenCompose(
						quote -> CompletableFuture.supplyAsync(
								() -> Discount.applyDiscount(quote), executor)
				));
		return completableFutureStream;
	}

	public void printPricesStream(String product) {
		long start = System.nanoTime();
		CompletableFuture[] futures = findPricesStream(product)
				.map(f -> f.thenAccept(s -> System.out.println(s + " (done in " + ((System.nanoTime() - start) / 1_000_000) + " msecs)")))
				.toArray(size -> new CompletableFuture[size]);
		CompletableFuture.allOf(futures).join();
		System.out.println("All shops have now responded in " + ((System.nanoTime() - start) / 1_000_000) + " msecs");
	}

}
