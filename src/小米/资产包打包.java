package 小米;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class 资产包打包 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(",");
        int m = Integer.parseInt(strs[0]); //资产总量
        int n = Integer.parseInt(strs[1]); //资产种类
        String[] T = strs[2].split(" ");
        String[] V = strs[3].split(" ");
        int[] t = new int[n]; //资产条数
        int[] v = new int[n]; //资产价值
        for(int i = 0; i < n; i++) {
            t[i] = Integer.parseInt(T[i]);
            v[i] = Integer.parseInt(V[i]);
        }
        int[][] dp = new int[n+1][m+1]; //dp[i][j]表示前i个资产能够凑成j容量的最大资产价值
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                dp[i][j] = dp[i-1][j]; //不选择当前资产
                if(j-t[i-1]<0)
                    continue;
                else
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-t[i-1]]+v[i-1]); //选择当前资产
            }
        }
        System.out.println(dp[n][m]);
    }
}
