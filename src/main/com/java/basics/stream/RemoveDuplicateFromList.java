package main.com.java.basics.stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import com.google.common.collect.Lists;
import java.util.stream.Collectors;
/**
 * @author Heena Hussain
 *
 */
public class RemoveDuplicateFromList
{
	public static void main(String[] args)
	{
		List<Integer> integerWithDups = Arrays.asList(0,1,2,3,0,0);
		// Using hash set
		List<Integer> integerWithoutDups = new ArrayList<>(new HashSet<>(integerWithDups));
		System.out.println(integerWithoutDups.size() == 5 ? "correct" : "incorrect");

		//Using Guava library
		integerWithoutDups = Lists.newArrayList(integerWithDups);
		System.out.println(integerWithoutDups.size() == 5 ? "correct" : "incorrect");

		//Using lambdas
		integerWithoutDups = integerWithDups.stream().distinct().collect(Collectors.toList());
		System.out.println(integerWithoutDups.size() == 5 ? "correct" : "incorrect");
	}
}
