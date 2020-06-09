package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 最少数量货物装箱问题 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        int[] dp = new int[n+1]; //dp[i]表示装满i需要最少货物数量
        int[] arr = {3,5,7};
        Arrays.fill(dp, 10001);
        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < 3; j++) {
                if(i-arr[j]<0) break;
                dp[i] = Math.min(dp[i], dp[i-arr[j]]+1);
            }
        }
        System.out.println(dp[n]==10001? -1 : dp[n]);
    }
}
