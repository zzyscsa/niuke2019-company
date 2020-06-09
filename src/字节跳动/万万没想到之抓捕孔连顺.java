package 字节跳动;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 万万没想到之抓捕孔连顺 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int mod = 99997867;
        String[] strs = bf.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int d = Integer.parseInt(strs[1]);
        strs = bf.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        long res = 0;
        int j = 0;
        for(int i = 2; i < n; i++) {
            while(arr[i]-arr[j]>d) j++;
            res += ((long)(i-j)*(long)(i-j-1)/2)%mod;
            res = res%mod;
        }
        System.out.println(res);
    }
}
