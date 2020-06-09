package 美团;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * 一条直线上等距离放置了n台路由器。路由器自左向右从1到n编号。第i台路由器到第j台路由器的距离为| i-j |。
 * 每台路由器都有自己的信号强度，第i台路由器的信号强度为ai。
 * 所有与第i台路由器距离不超过ai的路由器可以收到第i台路由器的信号（注意，每台路由器都能收到自己的信号）。
 * 问一共有多少台路由器可以收到至少k台不同路由器的信号。
输入描述:
输入第一行两个数n , k（1≤n , k≤10^5）

第二行n个数, a1 , a2 , a3……… , an（0≤ai≤10^9）
输出描述:
输出一个数，一共有多少台路由器可以收到至少k台不同路由器的信号。
4 4
3 3 3 3

4
 * */

public class 路由器 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int k = Integer.parseInt(strs[1]);
        int[] arr = new int[n];
        strs = bf.readLine().split(" ");
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(strs[i]);
        int[] temp = new int[n];
        for(int i = 0; i < n; i++) {
            //表示i路由器从i-arr[i]这个点往左都能覆盖到
            if(i-arr[i]<0)
                temp[0]++;
            else
                temp[i-arr[i]]++;
            //表示i路由器从i+arr[i]+1这个点开始，不再覆盖了，因此总结果减去这个路由器的个数
            if(i+arr[i]+1<n)
                temp[i+arr[i]+1]--;
        }
        int res = 0, count = 0;
        for(int i = 0; i < n; i++) {
            res += temp[i];
            if(res >= k)
                count++;
        }
        System.out.println(count);
    }
}