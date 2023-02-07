package study_230207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea1289_원재의메모리복구하기_D3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			String word = br.readLine();
			int cnt = 0;
			boolean flag = false;

			for (int j = 0; j < word.length(); j++) {
				int tmp = word.charAt(j) - '0';

				if (tmp == 1 && !flag) {
					flag = true;
					cnt++;
				}else if (tmp == 1 && flag) {
					continue;
				}

				if (tmp == 0 && flag) {
					flag = false;
					cnt++;
				}else if(tmp == 0 && !flag) {
					continue;
				}
			}
			System.out.printf("#%d %d\n", i, cnt);
		}
	}
}
