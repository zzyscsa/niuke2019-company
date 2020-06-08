package 百度;

/*
 * 一个花坛中有很多花和两个喷泉。

喷泉可以浇到以自己为中心，半径为r的圆内的所有范围的花。

现在给出这些花的坐标和两个喷泉的坐标，要求你安排两个喷泉浇花的半径r1和r2，
使得所有的花都能被浇到的同时, r1平方 + r2平方 的值最小。
输入描述:
第一行5个整数n，x1，y1，x2，y2表示花的数量和两个喷泉的坐标。
接下来n行，每行两个整数xi, yi表示第i朵花的坐标。
满足1 <= n <= 2000，花和喷泉的坐标满足-107<= x, y <= 107。
输出描述:
一个整数，r12 + r22 的最小值。
2 -1 0 5 3
0 2
5 2

6
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 浇花 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int a = Integer.parseInt(strs[1]);
        int b = Integer.parseInt(strs[2]);
        int c = Integer.parseInt(strs[3]);
        int d = Integer.parseInt(strs[4]);
        long[][] arr = new long[n][2];
        for(int i = 0; i < n; i ++) {
            strs = bf.readLine().split(" ");
            int x = Integer.parseInt(strs[0]);
            int y = Integer.parseInt(strs[1]);
            arr[i][0] = (long)(Math.pow(x-a, 2)+Math.pow(y-b, 2));
            arr[i][1] = (long)(Math.pow(x-c, 2)+Math.pow(y-d, 2));
        }
        Arrays.sort(arr, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return (int)(o2[0]-o1[0]); //根据到第一个喷泉距离从大到小排序
            }
        });
        long min = Long.MAX_VALUE;
        long temp = 0;
        for(int i = 0; i < n; i++) {
            min = Math.min(min, arr[i][0]+temp); //i后面的包括i都属于第一个喷泉，
            temp = Math.max(temp, arr[i][1]);//i前面的属于第二个喷泉，找它的最大值
        }
        System.out.println(Math.min(min, temp)); //特殊情况是所有点都属于第二个喷泉，所以取最小。
    }
}
