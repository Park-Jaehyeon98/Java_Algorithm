package study_230207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj4153_직각삼각형B3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 0 || b == 0 || c == 0) {
				break;
			}

			if (a > b && a > c) {
				if (Math.pow(a, 2) == (Math.pow(b, 2) + Math.pow(c, 2))) {
					System.out.println("right");
				} else
					System.out.println("wrong");
			} else if (b > c && b > a) {
				if (Math.pow(b, 2) == (Math.pow(a, 2) + Math.pow(c, 2))) {
					System.out.println("right");
				} else
					System.out.println("wrong");
			} else if (c > a && c > b) {
				if (Math.pow(c, 2) == (Math.pow(a, 2) + Math.pow(b, 2))) {
					System.out.println("right");
				} else
					System.out.println("wrong");
			} else
				System.out.println("wrong");

		}

	}

}
