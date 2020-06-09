package 美团;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * 小明同学在参加一场考试，考试时间2个小时。试卷上一共有n道题目，小明要在规定时间内，完成一定数量的题目。
 * 考试中不限制试题作答顺序，对于 i 第道题目，小明有三种不同的策略可以选择:  (1)直接跳过这道题目，不花费时间，本题得0分。

(2)只做一部分题目，花费pi分钟的时间，本题可以得到ai分。  (3)做完整个题目，花费qi分钟的时间，本题可以得到bi分。

小明想知道，他最多能得到多少分。

输入描述:
第一行输入一个n数表示题目的数量。

接下来n行，每行四个数p_i，a_i，q_i，b_i。(1≤n≤100，1≤p_i≤q_i≤120，0≤a_i≤b_i≤1000
)。
输出描述:
输出一个数，小明的最高得分。

4
20 20 100 60
50 30 80 55
100 60 110 88
5 3 10 6

94
 * */

public class 考试策略 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        String[] strs;
        int[] p = new int[n];
        int[] a = new int[n];
        int[] q = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++) {
            strs = bf.readLine().split(" ");
            p[i] = Integer.parseInt(strs[0]);
            a[i] = Integer.parseInt(strs[1]);
            q[i] = Integer.parseInt(strs[2]);
            b[i] = Integer.parseInt(strs[3]);
        }
        int[][] dp = new int[n+1][121];
        for(int i = 0; i <= n; i++)
            dp[i][0] = 0;
        for(int i = 0; i <= 120; i++)
            dp[0][i] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= 120; j++) {
                if(j-p[i-1]<0) { //没时间，都不做
                    dp[i][j] = dp[i-1][j];
                } else if(j-q[i-1]<0) { //只有做一部分的时间
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-p[i-1]]+a[i-1]);
                } else { //有做完全部题目的时间
                    dp[i][j] = Math.max(dp[i-1][j], Math.max(dp[i-1][j-p[i-1]]+a[i-1], dp[i-1][j-q[i-1]]+b[i-1]));
                }
            }
        }
        System.out.println(dp[n][120]);
    }
}
