package study_230215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj16935_배열돌리기3_S1 {

	static int n, m, r;
	static int[][] area;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		area = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < r; i++) {
			switch (Integer.parseInt(st.nextToken())) {
			case 1:
				rotate1();
				break;
			case 2:
				rotate2();
				break;
			case 3:
				rotate3();
				int tmp = n;
				n = m;
				m = tmp;
				break;
			case 4:
				rotate4();
				int tmp1 = n;
				n = m;
				m = tmp1;
				break;
			case 5:
				rotate5();
				break;
			case 6:
				rotate6();
				break;
			}

		}
		
		for(int i = 0; i<n;i++) {
			for(int j=0; j<m;j++) {
				System.out.print(area[i][j] + " ");
			}
			System.out.println();
			
		}
	}

	public static void rotate1() {
		int idx = n - 1;
		int[][] temp = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[i][j] = area[idx][j];
			}
			idx--;
		}
		area = temp;
	}

	public static void rotate2() {
		int idx = m - 1;
		int[][] temp = new int[n][m];

		for (int j = 0; j < m; j++) {
			for (int i = 0; i < n; i++) {
				temp[i][j] = area[i][idx];
			}
			idx--;
		}
		area = temp;
	}

	public static void rotate3() {
		int idx = n - 1;
		int[][] temp = new int[m][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[j][idx] = area[i][j];
			}
			idx--;
		}
		area = temp;
	}

	public static void rotate4() {
		int[][] temp1 = new int[m][n];
		Queue<Integer> temp = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp.add(area[i][j]);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = m - 1; j >= 0; j--) {
				temp1[j][i] = temp.poll();
			}
		}
		area = temp1;
	}

	public static void rotate5() {
		int[][] temp = new int[n][m];
		int x = n / 2;
		int y = m / 2;

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				temp[i][j + y] = area[i][j];
			}
		}
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				temp[i + x][j + y] = area[i][j + y];
			}
		}
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				temp[i + x][j] = area[i + x][j + y];
			}
		}
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				temp[i][j] = area[i + x][j];
			}
		}
		area = temp;
	}

	public static void rotate6() {
		int[][] temp = new int[n][m];
		int x = n / 2;
		int y = m / 2;

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				temp[i + x][j + y] = area[i + x][j];
			}
		}
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				temp[i][j + y] = area[i + x][j + y];
			}
		}
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				temp[i + x][j] = area[i][j];
			}
		}
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				temp[i][j] = area[i][j + y];
			}
		}
		area = temp;
	}

}
