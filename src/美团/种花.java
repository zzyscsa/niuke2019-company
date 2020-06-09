package 美团;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * 公园里有N个花园，初始时每个花园里都没有种花，园丁将花园从1到N编号并计划在编号为i的花园里恰好种A_i朵花，
 * 他每天会选择一个区间[L，R]（1≤L≤R≤N）并在编号为L到R的花园里各种一朵花，那么园丁至少要花多少天才能完成计划？

输入描述:
第一行包含一个整数N，1≤N≤10^5。

第二行包含N个空格隔开的整数A_1到A_N，0≤A_i≤10^4。
输出描述:
输出完成计划所需的最少天数。
5
4 1 8 2 5

14
 * */

public class 种花 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        String[] strs = bf.readLine().split(" ");
        int[] arr = new int[n+1];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(strs[i]);
        int res = 0;
        for(int i = 0; i < n; i++) {
            //如果后一个比前一个小，那么前一个先种arr[i]-arr[i+1]，这样后一个种的时候就直接把前一个剩下的一起种了
            //如果后一个比前一个打，那么后一个种的时候前一个肯定也一起种了，以此类推。
            if(arr[i]>arr[i+1])
                res += arr[i]-arr[i+1];
        }
        System.out.println(res);
    }
}