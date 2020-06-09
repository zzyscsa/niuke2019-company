package 哔哩哔哩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class 精灵鼠从入口到出口的最少减少速度 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        int[][] arr = new int[n][n];
        String[] strs;
        for(int i = 0; i < n; i++) {
            strs = bf.readLine().split(",");
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(strs[j]);
            }
        }
        int[][] dp = new int[n][n];
        dp[0][0] = arr[0][0];
        //初始化
        for(int i = 1; i < n; i++)
            dp[i][0] = dp[i-1][0]+arr[i][0];
        for(int j = 1; j < n; j++)
            dp[0][j] = dp[0][j-1]+arr[0][j];

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+arr[i][j];
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}
