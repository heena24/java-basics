package main.com.java.basics.Iterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/**
 * @author Heena Hussain
 *
 */
public class IteratorExample
{
	public static void main(String[] args)
	{
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3));
		Iterator i = arr.iterator();

		while(i.hasNext())
		{
			System.out.println(i.next());
			i.remove();
		}

		System.out.println("end: " + i.next()); // iterator ends here with no elements left to iterate
		System.out.println("Array " + Arrays.toString(arr.toArray())); //iterator remove affect the arr because reference to same location
	}
}
