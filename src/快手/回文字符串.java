package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 最大回文子串是被研究得比较多的一个经典问题。最近月神想到了一个变种，对于一个字符串，
 * 如果不要求子串连续，那么一个字符串的最大回文子串的最大长度是多少呢。
 *
 * adbca
 * 3
 * */


public class 回文字符串 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int n = s.length();
        int[][] dp = new int[n+1][n+1]; //dp[i][j]表示从i到j最长回文序列长度
        for(int i = 1; i <= n; i++)
            dp[i][i] = 1;
        for(int i = n; i > 0; i--) {
            for(int j = i+1; j <= n; j++) {
                if(s.charAt(i-1)==s.charAt(j-1)) {
                    dp[i][j] = dp[i+1][j-1]+2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[1][n]);
    }
}
