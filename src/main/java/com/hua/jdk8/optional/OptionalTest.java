package com.hua.jdk8.optional;

import static com.hua.jdk8.utils.Print.*;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * <pre>
 *     Optional实际上是个容器：它可以保存类型T的值，或者仅仅保存null。
 *     Optional提供很多有用的方法，这样我们就不用显式进行空值检测。
 *     optional01 构建了一个值为1的对象
 *     optional02 构建了一个null对象
 * </pre>
 * created at 2019-06-25 18:25
 * @author lerry
 */
public class OptionalTest {

	public static void main(String[] args) {

		printlnf("空的Optional，调用isPresent会返回：%s", Optional.empty().isPresent());


		// 返回具有指定的当前非空值的可选值 如果参数为空，会抛出NullPointerException异常
		Optional<Integer> optional01 = Optional.of(1);
		printlnf(optional01.toString());


		// ofNullable()参数可以是null
		Optional<Integer> optional02 = Optional.ofNullable(null);
		printlnf(optional02.toString());

		// ofNullable() 参数也可以是非null
		Optional<Integer> optional03 = Optional.ofNullable(2);
		printlnf(optional03.toString());

		Optional<Integer> optionalNull01 = Optional.ofNullable(null);
		Optional<Integer> optionalNull02 = Optional.ofNullable(null);
		printlnf("两个Optional空对象是否==？ %s", optionalNull01 == optionalNull02);
		printlnf("两个Optional空对象是否== Optional.<Integer>empty()？ %s", optionalNull01 == Optional.<Integer>empty());

		printlnf("判断值是否存在(optional01.isPresent())：%s", optional01.isPresent());
		printlnf("判断值是否存在(optional02.isPresent())：%s", optional02.isPresent());

		// 如果不是null,调用Consumer
		printlnf("ifPresent的测试：");
		optional01.ifPresent(integer -> printlnf("value is %s", integer));
		optional01.ifPresent(integer -> printlnf("value is %s", optional01.get()));
		// null,不调用Consumer
		printlnf("如果Optional中值不存在，则ifPresent方法不会执行：");
		optional02.ifPresent(integer -> printlnf("value is %s", integer));

		printlnf("如果有值就返回，若没有，则返回指定的值 optional01.orElse(1000):%s", optional01.orElse(1000));
		printlnf("如果有值就返回，若没有，则返回指定的值 optional02.orElse(1000):%s", optional02.orElse(1000));

		printlnf("如果有值就返回，若没有，则返回指定的值 optional01.orElseGet(() -> 2000):%s", optional01.orElseGet(() -> 2000));
		printlnf("如果有值就返回，若没有，则返回指定的值 optional02.orElseGet(() -> 2000):%s", optional02.orElseGet(() -> 2000));


		// orElseThrow()：值不存在则抛出异常，存在则什么不做
		printlnf("orElseThrow()：值不存在则抛出异常，存在则什么不做:");
		try {
			optional01.orElseThrow((Supplier<Throwable>) () -> {
				throw new IllegalStateException();
			});
		}
		catch (Throwable throwable) {
			throwable.printStackTrace();
		}

		try {
			optional02.orElseThrow((Supplier<Throwable>) () -> {
				throw new IllegalStateException();
			});
		}
		catch (Throwable throwable) {
			throwable.printStackTrace();
		}

		// filter(Predicate)：判断Optional对象中保存的值是否满足Predicate，并返回新的Optional。
		Optional<Integer> filter1 = optional01.filter((a) -> a == null);
		Optional<Integer> filter2 = optional01.filter((a) -> a == 1);
		Optional<Integer> filter3 = optional02.filter((a) -> a == null);
		printlnf("optional01.filter((a) -> a == null):%s", filter1.isPresent());
		printlnf("optional01.filter((a) -> a == 1):%s", filter2.get().intValue() == 1);
		printlnf("optional02.filter((a) -> a == null):%s", filter3.isPresent());


		// map(Function)：对Optional中保存的值进行函数运算，并返回新的Optional(可以是任何类型)
		Optional<String> str1Optional = optional01.map((a) -> "key" + a);
		Optional<String> str2Optional = optional02.map((a) -> "key" + a);

		// key1
		printlnf("optional01.map((a) -> \"key\" + a):%s", str1Optional.get());
		// false
		printlnf("optional02.map((a) -> \"key\" + a):%s", str2Optional.isPresent());
//		System.out.println(str2Optional.get());// NoSuchElementException

		// map方法的mapping函数返回值可以是任何类型T，而flatMap方法的mapping函数必须是Optional。
		Optional<Optional<String>> str3Optional = optional01.map((a) -> {
			return Optional.<String>of("key" + a);
		});

		Optional<String> str4Optional = optional01.flatMap((a) -> {
			return Optional.<String>of("key" + a);
		});

		System.out.println(str3Optional.get().get());// key1
		System.out.println(str4Optional.get());// key1


		printlnf("flatMap 如果值存在，就对该值执行提供的 mapping 函数调用，返回一个 Optional 类型的值，否则就返" +
				"回一个空的 Optional 对象:");
		// 如果值存在，就对该值执行提供的 mapping 函数调用，返回一个 Optional 类型的值，否则就返
		//回一个空的 Optional 对象
		Optional<String> flatMap01 = optional01.flatMap((a) -> Optional.of("key" + a));
		printlnf(flatMap01);

		Optional<String> flatMap02 = optional02.flatMap((a) -> Optional.of("key" + a));
		printlnf(flatMap02);

	}
}
