package collection;

import java.util.PriorityQueue;

public class PriorityQueneTest {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(6);
		pq.offer(-3);
		pq.offer(20);
		pq.offer(18);
		System.out.println(pq);
	}
}
