 package study_230213;

import java.io.*;
import java.util.*;

public class Bj1158_요세푸스문제_S4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}

		sb.append("<");
		while (q.size() != 1) {
			for (int i = 1; i < K; i++) {
				q.offer(q.poll());
			}
			sb.append(q.poll() + ", ");
		}
		sb.append(q.poll() + ">");
		System.out.println(sb);
	}
}