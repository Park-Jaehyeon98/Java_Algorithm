package study_230213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj2493_탑_G5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Tower[] stack = new Tower[N];
		int top = 0;
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) { // 1번 타워부터 N번 타워까지 순서대로 입장
			Tower now = new Tower(i, Integer.parseInt(st.nextToken()));

			// 스택에 (나보다 왼쪽에 있던) 작은 놈들은 다 치워. 그러면 비거나 큰놈일때 반복 종료
			while (top>0 && stack[top-1].height < now.height)
				top--;

			if (top == 0) // 결국 다 작은 애들이면 0
				sb.append("0 ");
			else
				sb.append(stack[top-1].num + " ");

			stack[top] = now;
			top++;
		}
		System.out.println(sb);
	}

	static class Tower {
		int num, height;

		Tower(int num, int height) {
			this.num = num;
			this.height = height;
		}
	}

}
