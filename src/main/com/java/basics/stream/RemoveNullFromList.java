package main.com.java.basics.stream;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.PredicateUtils;
/**
 * @author Heena Hussain
 *
 */
public class RemoveNullFromList
{
	public static void main(String[] args)
	{
		List<Integer> list = Lists.newArrayList(null,1,null);
		// Arrays.asList throw  error
		while (list.remove(null));
		System.out.println("Size1: " + list.size());

		list = Lists.newArrayList(null,1,null);
		list.removeAll(Collections.singleton(null));
		System.out.println("Size2: " + list.size());

		// Using Guava
		list = Lists.newArrayList(null,1,null);
//		list.removeIf(Predicates.isNull());
		Iterables.removeIf(list, Predicates.isNull());
		System.out.println("Size3: " + list.size());

		//without modifying the source  list
		List<Integer> newlist = Lists.newArrayList(Iterables.filter(list, Predicates.notNull()));
		System.out.println("Size4: " + newlist.size());

		// Using Apache commons
		list = Lists.newArrayList(null,1,null);
		CollectionUtils.filter(list, PredicateUtils.notNullPredicate());
		System.out.println("Size5: " + newlist.size());

		// USING LAMBDA
		list = Lists.newArrayList(null,1,null);
		list  = list.stream().filter(Predicates.notNull()).collect(Collectors.toList());
//		list  = list.parallelStream().filter(Predicates.notNull()).collect(Collectors.toList());
//		list.removeIf(Objects::isNull);
		System.out.println("Size6: " + list.size());

		List<Integer> parallel = Lists.newArrayList(null, 1, 2, null, 3, null);
		List<Integer> listWithoutNulls = parallel.parallelStream()
				.filter(Objects::nonNull)
				.collect(Collectors.toList());

	}
}
