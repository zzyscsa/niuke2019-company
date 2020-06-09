package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 搭积木 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        int[][] arr = new int[n][2];
        String[] strs;
        for(int i = 0; i < n; i++) {
            strs = bf.readLine().split(" ");
            arr[i][0] = Integer.parseInt(strs[0]);
            arr[i][1] = Integer.parseInt(strs[1]);
        }
        //按照宽从小到大排序
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return o1[0]-o2[0];
            }
        });
        //求长度的最大递增子序列,普通动态规划超时,用二分查找+贪心
        int[] dp = new int[n];
        int res = 0;
        for(int i = 0; i < n; i++) {
            int left = 0;
            int right = res-1;
            while(left<=right) {
                int mid = left+(right-left)/2;
                if(dp[mid]<=arr[i][1]) left = mid+1;
                else right = mid-1;
            }
            dp[left] = arr[i][1];
            if(right == res-1) res++;
        }
        System.out.println(res);
    }
}
