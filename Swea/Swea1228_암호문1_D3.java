package study_230213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Swea1228_암호문1_D3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {
			int first_line = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			List<Integer> list = new LinkedList<>();

			for (int i = 0; i < first_line; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			String com_num = br.readLine();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < com_num.charAt(0) - '0'; i++) {
				String com = st.nextToken();
				int idx = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				for (int j = 0; j < n; j++) {
					list.add(idx + j, Integer.parseInt(st.nextToken()));
				}
			}

			System.out.printf("#%d ", t);
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}

	}

}
