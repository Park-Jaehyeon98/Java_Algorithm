package study_230209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Bj12891_DNA비밀번호_S2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		char[] word = new char[s];
		int[] num = new int[4];
		int cnt = 0;

		String line = br.readLine();
		for (int i = 0; i < s; i++) {
			word[i] = line.charAt(i);
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < p; i++) {
			if (word[i] == 'A') {
				num[0] -= 1;
			} else if (word[i] == 'C') {
				num[1] -= 1;
			} else if (word[i] == 'G') {
				num[2] -= 1;
			} else if (word[i] == 'T') {
				num[3] -= 1;
			}
		}

		for (int i = 0; i < 4; i++) {
			if (num[i] > 0)
				break;

			if (i == 3)
				cnt++;
		}

		for (int i = p; i < word.length; i++) {
			if (word[i - p] == 'A') {
				num[0] += 1;
			} else if (word[i - p] == 'C') {
				num[1] += 1;
			} else if (word[i - p] == 'G') {
				num[2] += 1;
			} else if (word[i - p] == 'T') {
				num[3] += 1;
			}
			if (word[i] == 'A') {
				num[0] -= 1;
			} else if (word[i] == 'C') {
				num[1] -= 1;
			} else if (word[i] == 'G') {
				num[2] -= 1;
			} else if (word[i] == 'T') {
				num[3] -= 1;
			}
			for (int j = 0; j < 4; j++) {
				if (num[j] > 0) {
					break;
				}
				if (j == 3)
					cnt++;
			}
		}
		System.out.println(cnt);

	}

}
