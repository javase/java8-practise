package lambdasinaction.chap11;

import static com.hua.jdk8.utils.Print.*;
import static lambdasinaction.chap11.Util.*;

public class Discount {

	public enum Code {
		NONE(0),
		SILVER(5),
		GOLD(10),
		PLATINUM(15),
		DIAMOND(20);

		private final int percentage;

		Code(int percentage) {
			this.percentage = percentage;
		}

	}

	/**
	 * 应用折扣策略
	 * @param quote
	 * @return
	 */
	public static String applyDiscount(Quote quote) {
		return quote.getShopName() + " price is " + Discount.apply(quote.getPrice(), quote.getDiscountCode());
	}

	/**
	 * 应用打折策略
	 * @param price
	 * @param code
	 * @return
	 */
	private static double apply(double price, Code code) {
		delay();
		int discount = 100 - code.percentage;
		printlnf("打折：%d折", discount);
		double priceStr = price * (discount) / 100;
		return format(priceStr);
	}
}
