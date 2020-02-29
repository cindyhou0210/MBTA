package main;
/**
 *This class provides the implementation of a generic circular first-in-first-out queue. In your
implementation
 *
 * @author cindy hou

 */
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Queue<T> {

	public T[] q;
	public int head;
	public int tail;
	public int numEntries;

	@SuppressWarnings("unchecked")

	/**
	 * constructs an empty queue that can hold a specified
number of elements. You will find that one line of this method has been provided in the skeleton
code.
	 * @param capacity
	 */
	public Queue(int capacity) {
		this.q = (T[]) new Object[capacity];
	}

	public void enqueue(T element) {

		q[tail] = element;
		if(tail == q.length) {
			tail = 1;
		} else {
			tail = tail + 1;
		}
		numEntries++;

	}

	public void dequeue() {
		if(tail < head) {
			throw new NoSuchElementException("list is empty");
		}
		if(head == q.length) {
			head = 1;
		} else {
			head += 1;
		}
		numEntries--;
	}

	public T front() {
		if(tail < head) {
			throw new NoSuchElementException("list empty");
		}
		return q[head];
	}

	public int size() {
		return numEntries;
	}

	@Override
	public String toString() {

		return Arrays.toString(q);
	}
}
