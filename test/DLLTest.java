package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.DoubleLinkedList;
import main.Node;

class DLLTest<T> {

	@Test
	void testConstructor() {
		DoubleLinkedList<T> db = new DoubleLinkedList<T>();
		Node<T> actual = db.getFirst();
		Node<T> expected = null;
		assertEquals(actual, expected);
	}

	@Test
	void testgetFirst() {
		DoubleLinkedList<Integer> db = new DoubleLinkedList<Integer>();
		db.insert(2);
		//Node<Integer> newNode = new Node<Integer>(2);
		Integer actual = db.getFirst().getElement();
		Integer expected = 2;
		assertEquals(actual, expected);
	}

	@Test
	void testInsert() {
		DoubleLinkedList<Integer> db = new DoubleLinkedList<Integer>();
		db.insert(2);
		int actual = db.size();
		int expected = 1;
		assertEquals(actual, expected);
	}

	@Test
	void testDelete() {
		DoubleLinkedList<Integer> db = new DoubleLinkedList<Integer>();
		db.insert(2);
		db.delete(2);
		int actual = db.size();
		int expected = 0;
		assertEquals(actual, expected);
	}

	@Test
	void testGet() {
		DoubleLinkedList<Integer> db = new DoubleLinkedList<Integer>();
		db.insert(2);
		Integer actual = db.get(2);
		Integer expected = 2;
		assertEquals(actual, expected);
	}

	@Test
	void  testSize() {
		DoubleLinkedList<Integer> db = new DoubleLinkedList<Integer>();
		db.insert(2);
		int actual = db.size();
		int expected = 1;
		assertEquals(actual, expected);
	}

}
