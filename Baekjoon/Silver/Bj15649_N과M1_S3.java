package study_230207;

import java.util.Arrays;
import java.util.Scanner;

public class Bj15649_N과M1_S3 {

	static int n, m;
	static int[] cards;
	static boolean[] used;
	static int[] result;
	static StringBuilder sb;

	static void perm(int idx) {
		if (idx == m) {
			for (int i = 0; i < result.length; i++) {
				sb.append(result[i] + " ");
				if (i % m == m-1)
					sb.append("\n");

			}
			return;
		}
		for (int i = 0; i < n; i++) {
			if (used[i])
				continue;
			result[idx] = cards[i];
			used[i] = true;

			perm(idx + 1);
			used[i] = false;

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		n = sc.nextInt();
		m = sc.nextInt();
		cards = new int[n];
		used = new boolean[n];
		result = new int[m];

		for (int i = 1; i <= n; i++) {
			cards[i - 1] = i;
		}

		perm(0);

		System.out.println(sb);
	}

}
