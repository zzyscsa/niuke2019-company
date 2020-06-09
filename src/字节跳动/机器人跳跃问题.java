package 字节跳动;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 机器人跳跃问题 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        int[] arr = new int[n];
        String[] strs = bf.readLine().split(" ");
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(strs[i]);
        //从后往前推，最坏的情况就是每跳一次能量都减少，到最后一个减为0
        int E = 0;
        for(int i = n-1; i >= 0; i--) {
            int temp = E+arr[i];
            if(temp%2==0)
                E = temp/2;
            else
                E = temp/2+1; //向上取整
        }
        System.out.println(E);
    }
}
