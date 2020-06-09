package 美团;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 你打开了美了么外卖，选择了一家店，你手里有一张满X元减10元的券，店里总共有n种菜，
 * 第i种菜一份需要A_i元，因为你不想吃太多份同一种菜，所以每种菜你最多只能点一份，现在问你最少需要选择多少元的商品才能使用这张券。
 * 输入描述:
第一行两个正整数n和X，分别表示菜品数量和券的最低使用价格。（1≤n≤100, 1≤X≤10000） 接下来一行n个整数，第i个整数表示第i种菜品的价格。（1≤A_i≤100）
输出描述:
一个数，表示最少需要选择多少元的菜才能使用这张满X元减10元的券，保证有解。

5 20
18 19 17 6 7

23
 * */

public class 外卖满减 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int x = Integer.parseInt(strs[1]);
        int[] arr = new int[n];
        strs = bf.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        int[][] dp = new int[n+1][x+1];
        for(int i = 0; i <= x; i++) {
            dp[0][i] = 100000;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= x; j++) { //背包容量
                if(arr[i-1]>=j) {
                    dp[i][j] = Math.min(arr[i-1], dp[i-1][j]);
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], arr[i-1]+dp[i-1][j-arr[i-1]]);
                }
            }
        }
        System.out.println(dp[n][x]);
    }
}