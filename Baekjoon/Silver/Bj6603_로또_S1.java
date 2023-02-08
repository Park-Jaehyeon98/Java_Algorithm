package study_230208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj6603_로또_S1 {

	static int[] num;
	static int[] result;
	static int k;

	public static void comb(int cnt, int start) {
		if (cnt == 6) {
			for (int num : result) {
				System.out.print(num + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < k; i++) {
			result[cnt] = num[i];
			comb(cnt + 1, i + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k == 0)
				break;
			num = new int[k];
			result = new int[6];
			for (int i = 0; i < k; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			comb(0, 0);

			System.out.println();
		}

	}

}
