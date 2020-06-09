package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 魔法深渊 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int mod = 1000000003;
        int m = Integer.parseInt(bf.readLine().trim());
        int[] step = {1,2,4,8,16,32,64,128,256,512};
        for(int i = 0; i < m; i++) {
            int n = Integer.parseInt(bf.readLine().trim());
            int[] dp = new int[n+1];
            dp[0] = 1;
            for(int j = 1; j <= n; j++) {
                for(int k = 0; k < 10; k++) {
                    if(j-step[k]<0) {
                        break;
                    }
                    dp[j] += dp[j-step[k]]%mod;
                    dp[j] %= mod;
                }
            }
            System.out.println(dp[n]);
        }

    }
}
