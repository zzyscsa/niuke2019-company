package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 获得最多的奖金 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        String[] strs = bf.readLine().split(" ");
        int[] arr = new int[n];
        for(int i =0; i < n; i++)
            arr[i] = Integer.parseInt(strs[i]);
        if(n==1) System.out.println(arr[0]);
        int left = 0;
        int right = n-1;
        long sum1 = (long)arr[left];
        long sum2 = (long)arr[right];
        long max = 0;
        while(left<right) {
            if(sum1==sum2) {
                max = Math.max(max, sum2);
                left++;
                sum1 += (long)arr[left];
                right--;
                sum2 += (long)arr[right];
            } else if(sum1<sum2) {
                left++;
                sum1 += (long)arr[left];
            } else {
                right--;
                sum2 += (long)arr[right];
            }
        }
        System.out.println(max);
    }
}
