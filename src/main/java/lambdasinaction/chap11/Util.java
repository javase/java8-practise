package lambdasinaction.chap11;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Util {

	private static final Random RANDOM = new Random(0);

	private static final DecimalFormat formatter = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US));

	/**
	 * 人为延迟1秒
	 */
	public static void delay() {
		log.info("[delay]1s");
		int delay = 1000;
		//int delay = 500 + RANDOM.nextInt(2000);
		try {
			Thread.sleep(delay);
		}
		catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public static double format(double number) {
		synchronized (formatter) {
			return new Double(formatter.format(number));
		}
	}

	public static <T> CompletableFuture<List<T>> sequence(List<CompletableFuture<T>> futures) {
/*
        CompletableFuture<Void> allDoneFuture =
                CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
        return allDoneFuture.thenApply(v ->
                futures.stream().
                        map(future -> future.join()).
                        collect(Collectors.<T>toList())
        );
*/
		return CompletableFuture.supplyAsync(() -> futures.stream().
				map(future -> future.join()).
				collect(Collectors.<T>toList()));
	}
}
