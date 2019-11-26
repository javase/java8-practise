package lambdasinaction.chap5.practise;

import static com.hua.jdk8.utils.Print.*;
import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import lambdasinaction.chap5.Trader;
import lambdasinaction.chap5.Transaction;

/**
 * created at 2019-11-22 21:48
 * @author lerry
 */
public class TradersStreamPractise {
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
		);

		// 找出2011年发生的所有交易，并按交易额排序(从低到高)。
		print("找出2011年发生的所有交易，并按交易额排序(从低到高)：");
		transactions.stream()
				.filter(transaction -> transaction.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue))
				.forEach(System.out::println);

		//  交易员都在哪些不同的􏵩城市工作过?
		print(" 交易员都在哪些不同的城市工作过?");
		transactions.stream()
				.map(Transaction::getTrader)
				.map(Trader::getCity)
				.distinct()
				.forEach(System.out::println);

		// 查找所有来自于剑桥的交易员，并按姓名排序
		print("查找所有来自于剑桥的交易员，并按姓名排序");
		transactions.stream()
				.map(Transaction::getTrader)
				.filter(trader -> "Cambridge".equalsIgnoreCase(trader.getCity()))
				.sorted(Comparator.comparing(Trader::getName))
				.distinct()
				.forEach(System.out::println);

		// 返回所有交易员的􏵪姓名字符串，按字母顺序排序
		print("返回所有交易员的姓名字符串，按字母顺序排序");
		List<String> nameList = transactions.stream()
				.map(Transaction::getTrader)
				.map(Trader::getName)
				.distinct()
				.sorted()
				.collect(toList());
		printlnf("姓名字符串：%s", nameList);

		String nameStr = transactions.stream()
				.map(transaction -> transaction.getTrader().getName())
				.distinct()
				.sorted()
				.reduce("", (n1, n2) -> n1 + n2);
		printlnf("姓名字符串：%s", nameStr);

		// 更加高效的写法
		String traderNameStr = transactions.stream()
				.map(transaction -> transaction.getTrader().getName())
				.distinct()
				.sorted()
				.collect(joining());
		printlnf("姓名字符串：%s", traderNameStr);

		// 有没有交易员是在米兰工作的
		boolean ifHaveMilan = transactions.stream()
				.map(Transaction::getTrader)
				.anyMatch(trader -> "Milan".equals(trader.getCity()));
		printlnf("有没有交易员是在米兰工作的:%s", ifHaveMilan);

		// 打印生活在􏲏􏲐剑桥的交易员的所有交易额
		printlnf("打印生活在剑桥的交易员的所有交易额:");
		transactions.stream()
				.filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
				.map(Transaction::getValue)
				.forEach(value -> printf("%s,", value));

		printlnf("");
		// 所有交易中，最高的交易额是多少
		Integer maxValue = transactions.stream()
				.map(Transaction::getValue)
				.reduce(0, Integer::max);
		printlnf("所有交易中，最高的交易额是多少?  %s", maxValue);

		// 找到交易额最小的交易
		Optional<Transaction> optional = transactions.stream()
				.reduce((t1, t2) -> t1.getValue() > t2.getValue() ? t1 : t2);
		printlnf("找到交易额最小的交易:%s", optional.get());

		// 找到最小的交易额
		Optional<Transaction> transactionOptional = transactions.stream().min(Comparator.comparing(Transaction::getValue));
		printlnf("找到交易额最小的交易:%s", transactionOptional.get());
	}
}
