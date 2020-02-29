package main;
/**
 *This class provides the implementation of a doubly linked list node. These nodes should have a
pointer to the next node, a pointer to the previous node, and data.
 *
 * @author cindy hou

 */
public class Node<T> {

	Node<T> next= null;
	Node<T> prev = null;
	T value;
	/**
	 * constructs a doubly linked list node that holds a data
element but does not point to any other nodes.
	 * @param element
	 */
	public Node(T element) {
		this.value = element;
	}

	public void setElement(T element) {
		this.value = element;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public void setPrev(Node<T> prev) {
		this.prev= prev;
	}

	/**
	 * – returns the pointer to the next node or null if one does
not exist.
	 * @return
	 */
	public Node<T> getNext() {
		return this.next;
	}

	public Node<T> getPrev() {
		return this.prev;
	}

	public T getElement() {
		return this.value;
	}

	@Override
	public String toString() {
		return null;
	}
}
