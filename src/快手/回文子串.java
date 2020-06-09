package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 回文子串 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int res = 0;
        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        res += n;
        for(int i = n-1; i >= 0; i--) {
            for(int j = i+1; j < n; j++) {
                if(s.charAt(i)==s.charAt(j)) {
                    if(j-i<2) {
                        dp[i][j] = true;
                        res++;
                    } else {
                        if(dp[i+1][j-1]) {
                            dp[i][j] = true;
                            res++;
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }
}
