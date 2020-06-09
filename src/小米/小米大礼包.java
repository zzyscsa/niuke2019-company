package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 小米大礼包 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        String[] strs = bf.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(strs[i]);
        int m = Integer.parseInt(bf.readLine().trim());
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(dp[i][j]) break;
                dp[i][j] = dp[i-1][j];
                if(arr[i-1]<=j) {
                    dp[i][j] = dp[i-1][j-arr[i-1]]||dp[i][j];
                }
            }
        }
        System.out.println(dp[n][m]?1:0);
    }
}
