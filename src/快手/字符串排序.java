package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 字符串排序 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(bf.readLine().trim());
        int[] arr = new int[m];
        String s;
        for(int i = 0; i < m ; i++) {
            s = bf.readLine();
            s = s.substring(s.length()-6, s.length());
            arr[i] = Integer.valueOf(s);
        }
        Arrays.sort(arr);
        for(int i = 0; i < m; i++) {
            System.out.println(arr[i]);
        }
    }
}
