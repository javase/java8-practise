package lambdasinaction.chap11;

import static com.hua.jdk8.utils.Print.*;
import static lambdasinaction.chap11.Util.*;

import java.util.Random;

/**
 * ֵ使用CompletableFuture构建异步应用
 * 商店类
 */
public class Shop {

	private final String name;

	private final Random random;

	public Shop(String name) {
		this.name = name;
		random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
	}

	/**
	 * 随机生成打折策略，然后返回类似：BestPrice:130.63:GOLD 格式的字符串
	 * @param product
	 * @return
	 */
	public String getPrice(String product) {
		double price = calculatePrice(product);
		Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
		return name + ":" + price + ":" + code;
	}

	/**
	 * 计算价格，会延时1秒
	 * 使用charAt，根据产品名称，生成一个随机值作为价格
	 * @param product
	 * @return
	 */
	public double calculatePrice(String product) {
		delay();
		double price = format(random.nextDouble() * product.charAt(0) + product.charAt(1));
		printlnf("计算价格,price is [%s]", price);
		return price;
	}

	public String getName() {
		return name;
	}
}
