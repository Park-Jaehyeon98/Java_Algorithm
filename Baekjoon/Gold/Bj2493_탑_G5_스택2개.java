package study_230213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Bj2493_탑_G5_스택 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Stack<int[]> stack1 = new Stack<>();
		Stack<int[]> stack2 = new Stack<>();
		int[] results = new int[n];
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			stack1.add(new int[] { Integer.parseInt(st.nextToken()), i + 1 });
		}

		while (!stack1.isEmpty()) {
			if (!stack2.isEmpty()) {

				if (stack2.peek()[0] <= stack1.peek()[0]) {
					int[] pop = stack2.pop();
					results[pop[1] - 1] = stack1.peek()[1];
					continue;
				}
			}

			stack2.add(stack1.pop());
		}

		for (int i : results) {
			sb.append(i);
			sb.append(" ");
		}

		System.out.println(sb.toString());
	}
}