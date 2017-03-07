package collections;
import java.util.Comparator;

public class ReverseComparable<E> implements Comparator<E> {
	public int compare(E o1, E o2) {
		return ((Comparable<E>)o2).compareTo(o1);
	}
}
