package study_230209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea2001_파리퇴치_D2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int sum = 0;
		int max = Integer.MIN_VALUE;

		int t = Integer.parseInt(br.readLine());

		for (int T = 1; T < t + 1; T++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][n];
			max = Integer.MIN_VALUE;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n - m + 1; i++) {
				for (int j = 0; j < n - m + 1; j++) {
					sum = 0;
					for (int k = i; k < i + m; k++) {
						for (int l = j; l < j + m; l++) {
							sum += arr[k][l];
						}
					}
					if (max < sum)
						max = sum;
				}
			}

			System.out.printf("#%d %d\n", T, max);

		}

	}

}
