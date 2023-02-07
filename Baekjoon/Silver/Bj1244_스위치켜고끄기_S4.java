package study_230207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj1244_스위치켜고끄기_S4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i < n + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int student = Integer.parseInt(br.readLine());
		for (int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine());
			int mm = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			int idx = 0;

			if (mm == 1) {
				for (int j = 1; j < n + 1; j++) {
					if (j % num == 0) {
						if (arr[j] == 1) {
							arr[j] = 0;
						} else if (arr[j] == 0) {
							arr[j] = 1;
						}
					}
				}
			} else if (mm == 2) {
				while (true) {
					if (num + idx > arr.length || num - idx <= 0) {
						break;
					}
					if (num + idx == num - idx) {
						if (arr[num] == 1) {
							arr[num] = 0;
						} else {
							arr[num] = 1;
						}
					} else if (arr[num + idx] == arr[num - idx]) {
						if (arr[num + idx] == 1) {
							arr[num + idx] = 0;
						} else {
							arr[num + idx] = 1;
						}
						if (arr[num - idx] == 1) {
							arr[num - idx] = 0;
						} else {
							arr[num - idx] = 1;
						}
					} else {
						break;
					}
					idx++;
				}
			}
		}
		for (int i = 1; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			if (i % 20 == 0)
				System.out.println();
		}

	}

}
