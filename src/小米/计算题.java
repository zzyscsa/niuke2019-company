package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 计算题 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(",");
        int[] height = new int[strs.length];
        for(int i = 0; i < height.length; i++)
            height[i] = Integer.parseInt(strs[i]);
        long res = 0;
        int n = height.length;
        int[] max_left = new int[n];
        int[] max_right = new int[n];

        for(int i = 1; i < n-1; i++) {
            max_left[i] = Math.max(max_left[i-1], height[i-1]);
        }
        for(int i = n-2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i+1], height[i+1]);
        }
        for(int i = 1; i < n-1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if(min<=height[i]) {
                continue;
            } else {
                res += (long)(min-height[i]);
            }
        }
        System.out.println(res);
    }
}
