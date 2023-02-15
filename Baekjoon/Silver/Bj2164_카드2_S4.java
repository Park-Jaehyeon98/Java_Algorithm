package study_230210;

import java.util.*;
import java.io.*;

public class Bj2164_카드2_S4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Queue<Integer> queue = new LinkedList<>();

		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++)
			queue.offer(i);

		while (queue.size() > 1) {
			queue.poll();
			queue.offer(queue.poll());
		}

		System.out.println(queue.poll());
	}
}