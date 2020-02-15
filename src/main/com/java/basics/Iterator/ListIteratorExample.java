package main.com.java.basics.Iterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
/**
 * @author Heena Hussain
 * 1. Flexibility to traverse the list from any point
 * 2. Ability to traverse back and fro
 * 3. Ability to add elements in the list
 * 4. Also get the index of the element
 */
public class ListIteratorExample
{
	public static void main(String[] args)
	{
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3));
		ListIterator<Integer> listIterator = arr.listIterator(arr.size());

		while(listIterator.hasPrevious())
		{
			System.out.println("Previous: " + listIterator.previous());
		}


		while(listIterator.hasNext())
		{
			int i = listIterator.next();
			System.out.println("Next: " + i);
		}
		listIterator.set(4); // It modify the last value in the array -> [1, 2, 4]


		listIterator.add(5);
		System.out.println("Array " + Arrays.toString(arr.toArray())); //[1, 2, 4, 5] - iterator add affect the arr because reference to same location
	}
}
