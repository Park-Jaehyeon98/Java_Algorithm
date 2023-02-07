package study_230207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Swea1208_Flatten_D3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 10;
		for(int t = 1; t<=T; t++) {
			List<Integer> list = new LinkedList<>();
			int num = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 100; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			for(int i = 0; i < num; i++) {
				Collections.sort(list);
				if(list.get(99) - list.get(0) <= 1)
					break;
				else {
					list.set(0, list.get(0)+1);
					list.set(99, list.get(99)-1);
				}
			}
			Collections.sort(list);
			System.out.printf("#%d %d\n", t, list.get(99)-list.get(0));
		}
		
	}

}
