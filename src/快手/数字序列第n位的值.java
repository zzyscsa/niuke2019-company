package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 数字序列第n位的值 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        int temp = 0;
        int i = 1;
        while(temp<n) {
            temp += i;
            i++;
        }
        System.out.println(i-1);
    }
}
