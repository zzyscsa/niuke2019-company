package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 求连续子数组最大和 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(",");
        int temp = 0;
        int max = 0;
        int min = 0;
        for(int i = 0; i < strs.length; i++) {
            int a = Integer.parseInt(strs[i]);
            temp += a;
            max = Math.max(max, temp-min);
            min = Math.min(temp, min);
        }
        System.out.println(max);
    }
}
