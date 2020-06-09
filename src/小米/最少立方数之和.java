package 小米;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class 最少立方数之和 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        int[] dp = new int[n+1];
        for(int i = 0; i <= n; i++)
            dp[i] = i; //最多的情况下就是全部都是1组成
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= 100; j++) {
                int temp = j*j*j;
                if(i-temp<0)
                    break;
                else {
                    dp[i] = Math.min(dp[i], dp[i-temp]+1);
                }
            }
        }
        System.out.println(dp[n]);
    }
}
