package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 厨艺大赛奖金 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int[] arr = new int[n];
        for(int i = 1; i <= n; i++)
            arr[i-1] = Integer.parseInt(strs[i]);
        int[] temp = new int[n];
        Arrays.fill(temp, 1);
        for(int i = 1; i < n; i++) {
            if(arr[i]>arr[i-1]) {
                temp[i] = temp[i-1]+1;
            }
        }
        for(int i = n-2; i >= 0; i--) {
            if(arr[i]>arr[i+1]) {
                temp[i] = Math.max(temp[i], temp[i+1]+1);
            }
        }
        int res = 0;
        for(int i = 0; i < n; i++)
            res += temp[i];
        System.out.println(res);
    }
}
