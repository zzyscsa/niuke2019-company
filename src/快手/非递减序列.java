package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 非递减序列 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        int[] arr = new int[strs.length];
        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(strs[i]);
        int cnt = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i]<arr[i-1]) {
                if(cnt==1) {
                    System.out.println(0);
                    return;
                }
                if(i==1 || arr[i]>=arr[i-2]) {
                    arr[i-1] = arr[i];
                } else if(arr[i]<arr[i-2]) {
                    arr[i] = arr[i-1];
                }
                cnt++;
            }
        }
        System.out.println(1);
    }
}
