package lambdasinaction.chap4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 和迭代器类似，流只能遍历一次。遍历完之后，我们就说这个流已经被消费了。
 * stream has already been operated upon or closed
 */
public class StreamVsCollection {

    public static void main(String...args){
        List<String> names = Arrays.asList("Java8", "Lambdas", "In", "Action");
        Stream<String> s = names.stream();
        s.forEach(System.out::println);
        // uncommenting this line will result in an IllegalStateException
        // because streams can be consumed only once
        //s.forEach(System.out::println);
    }
}