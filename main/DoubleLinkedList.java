package main;
/**
 * This class provides the implementation of a generic doubly linked list.
 *
 * @author cindy hou
 */
public class DoubleLinkedList<T> {

	Node<T>currNode;
	int size = 0;
	public DoubleLinkedList() {

	}
	/**
	 * gets the first node in the list or null if one does not exist.
	 * @return
	 */
	public Node<T> getFirst() {
		if(currNode ==null) {
			return null;
		}
		return currNode;
	}

	/**
	 * adds an element to the end of this list.
	 * @param element
	 */
	public void insert(T element) {
		Node<T> newNode = new Node<T>(element);
		Node<T> temp = currNode;
		if (getFirst() ==null) {
			currNode = newNode;
		} else {
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.prev = temp;
		}
		size++;
	}

	/**
	 * deletes the first element from this list that matches the
provided key. If the provided key does not exist in the list, return null.
	 * @param key
	 * @return
	 */
	public T delete(T key) {
		Node<T> current = currNode;
		if(current == null) {
			return null;
		}

		while (current.value != key && current.next != null) {
			current = current.next;
		}

		if(current.next != null) {
			current.prev.next = current.next;
			current.next.prev = current.prev;
		}
		size--;
		return key;
	}

	/**
	 * returns the first element in the list that matches the provided key
or null if one cannot be found.
	 * @param key
	 * @return
	 */
	public T get(T key) {
		Node<T> current = currNode;
		if(current == null) {
			return null;
		}
		while (current.value != key && current.next != null) {
			current = current.next;
		}
		if(current.next == null && current.value != key ) {
			return null;
		}
		return current.value;
	}

	/**
	 * returns the number of elements in the list.
	 * @return
	 */
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		String rep = "";
		Node<T> current = currNode;
		while(current.next != null) {
			rep += current.value.toString();
			current = current.next;
		}
		return rep;
	}
}
