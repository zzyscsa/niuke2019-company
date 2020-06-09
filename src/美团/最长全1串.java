package 美团;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * 给你一个01字符串，定义答案=该串中最长的连续1的长度，现在你有至多K次机会，每次机会可以将串中的某个0改成1，现在问最大的可能答案
 * 输入：	10 2
		1 0 0 1 0 1 0 1 0 1
	输出：5
 * */

public class 最长全1串 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        int N = Integer.parseInt(strs[0]);
        int K = Integer.parseInt(strs[1]);
        strs = bf.readLine().split(" ");
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(strs[i]);

        int max = 0;
        int[] temp = new int[N];
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            if(arr[i]==0) {
                cnt++;
                temp[cnt] = i;
            }
            if(cnt<=K) {
                max = Math.max(max, i+1);
                continue;
            } else {
                max = Math.max(max, i-temp[cnt-K]);
            }

        }
        System.out.println(max);
    }
}
