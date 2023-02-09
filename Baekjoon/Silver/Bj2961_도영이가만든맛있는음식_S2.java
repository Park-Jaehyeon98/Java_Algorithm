package study_230209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj2961_도영이가만든맛있는음식_S2 {

	static int[] sin;
	static int[] seon;
	static int min = Integer.MAX_VALUE;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		sin = new int[n];
		seon = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			sin[i] = Integer.parseInt(st.nextToken());
			seon[i] = Integer.parseInt(st.nextToken());

		}

		comb(0, 0, 1, 0);
		System.out.println(min);
	}

	public static void comb(int idx, int cnt, int sin_gop, int seon_sum) {
		if (cnt == n) {
			if (idx != 0) {
				min = Math.min(min, Math.abs(sin_gop - seon_sum));
			}
			return;
		}
		comb(idx + 1, cnt + 1, sin_gop * sin[cnt], seon_sum + seon[cnt]);
		comb(idx, cnt + 1, sin_gop, seon_sum);

	}

}