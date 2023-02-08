package study_230208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj11659_구간합구하기4_S3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] number = new int[n];
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			number[i] = Integer.parseInt(st.nextToken());
			if(i == 0)
				arr[i] = number[i];
			else {
				arr[i] = number[i] + arr[i-1];
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int tmp = 0;
			if(a>=2 && b <= n-1)
				tmp = arr[n-1] - (arr[a-2]+(arr[n-1]-arr[b-1]));
			else if(a==1)
				tmp = arr[n-1] - (arr[n-1]-arr[b-1]);
			else if(b == n && a >= 2)
				tmp = arr[n-1] - arr[a-2];
		
			System.out.println(tmp);
		}
		

	}

}
