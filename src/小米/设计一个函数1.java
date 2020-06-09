package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 设计一个函数1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(",");
        int m = Integer.parseInt(strs[strs.length-1]);
        int res = 0;
        int[] arr = new int[strs.length-1];
        for(int i = 0; i < strs.length-1; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i]+arr[j]==m) {
                    res += i+j;
                }
            }
        }
        System.out.println(res);
    }
}
