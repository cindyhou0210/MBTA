package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import main.Queue;

class QueueTest<T> {

	@Test
	void testConstructor() {
		Queue<T> q = new Queue <T>(5);
		int actual = q.q.length;
		int expected = 5;
		assertEquals(actual,expected);
	}

	@Test
	void testEnqueue() {
		Queue<Integer> q = new Queue <Integer>(5);
		q.enqueue(5);
		q.enqueue(6);
		int actual = q.size();
		int expected = 2;
		assertEquals(actual,expected);
	}

	@Test
	void testDequeue() {
		Queue<Integer> q = new Queue <Integer>(5);
		q.enqueue(5);
		q.enqueue(6);
		q.dequeue();
		int actual = q.size();
		int expected =1;
		assertEquals(actual,expected);
	}

	@Test
	void testFront() {
		Queue<Integer> q = new Queue <Integer>(5);
		q.enqueue(5);
		q.enqueue(6);
		Integer actual = q.front();
		Integer expected = 5;
		assertEquals(actual,expected);
	}

	@Test
	void testSize() {
		Queue<Integer> q = new Queue <Integer>(5);
		q.enqueue(5);
		q.enqueue(6);
		int actual = q.size();
		int expected = 2;
		assertEquals(actual,expected);
	}

	@Test
	void testToString() {
		Queue<Integer> q = new Queue <Integer>(2);
		q.enqueue(5);
		q.enqueue(6);
		String actual = q.toString();
		String expected = "[5, 6]";
		assertEquals(actual,expected);
	}

}
