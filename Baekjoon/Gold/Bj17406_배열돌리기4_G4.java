package study_230216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj17406_배열돌리기4_G4 {

	static int n, m, k, min = Integer.MAX_VALUE;
	static int[][] area;
	static int[][] num;
	static boolean[] isSelected;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		area = new int[n][m];
		num = new int[k][3];
		isSelected = new boolean[k];
		result = new int[k];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int l = 0; l < k; l++) {
			st = new StringTokenizer(br.readLine());
			num[l][0] = Integer.parseInt(st.nextToken());
			num[l][1] = Integer.parseInt(st.nextToken());
			num[l][2] = Integer.parseInt(st.nextToken());

		}
		
		perm(0);
		
		System.out.println(min);

	}

	public static void perm(int idx) {
		if (idx == k) {
			int[][] copy = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					copy[i][j] = area[i][j];
				}
			}
			cul(copy);

			return;
		}

		for (int i = 0; i < k; i++) {
			if (isSelected[i] == false) {
				isSelected[i] = true;
				result[idx] = i;
				perm(idx + 1);
				isSelected[i] = false;
			}
		}
	}

	public static void cul(int[][] copy) {
		for (int i = 0; i < result.length; i++) {
			int lx = num[result[i]][0] - num[result[i]][2] - 1;
			int ly = num[result[i]][1] - num[result[i]][2] - 1;
			int rx = num[result[i]][0] + num[result[i]][2] - 1;
			int ry = num[result[i]][1] + num[result[i]][2] - 1;
			rotate(lx, ly, rx, ry, copy);
		}

		for (int i = 0; i < copy.length; i++) {
			int sum = 0;
			for (int j = 0; j < copy[i].length; j++) {
				sum += copy[i][j];
			}
			min = Math.min(min, sum);
		}
		
	}

	public static void rotate(int lx, int ly, int rx, int ry, int[][] copy) {

		if (lx == rx && ly == ry) {
			return;
		}

		int[] temp = new int[3];
		temp[0] = copy[lx][ry];
		temp[1] = copy[rx][ry];
		temp[2] = copy[rx][ly];

		for (int i = ry; i > ly; i--) {
			copy[lx][i] = copy[lx][i - 1];
		}

		for (int i = rx; i > lx; i--) {
			if (i == lx + 1)
				copy[i][ry] = temp[0];
			else
				copy[i][ry] = copy[i - 1][ry];
		}

		for (int i = ly; i < ry; i++) {
			if (i == ry - 1)
				copy[rx][i] = temp[1];
			else
				copy[rx][i] = copy[rx][i + 1];
		}

		for (int i = lx; i < rx; i++) {
			if (i == rx - 1)
				copy[i][ly] = temp[2];
			else
				copy[i][ly] = copy[i + 1][ly];
		}
		rotate(lx + 1, ly + 1, rx - 1, ry - 1, copy);
	}

}
