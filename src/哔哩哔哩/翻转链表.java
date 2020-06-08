package 哔哩哔哩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class 翻转链表 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(",");
        int[] arr = new int[strs.length];
        int i = 0;
        int left = 0;
        int right = arr.length-1;
        StringBuffer sb = new StringBuffer();
        while(left<right) {
            if(i%2==0) {
                sb.append(strs[left++]);
            } else {
                sb.append(strs[right--]);
            }
            i++;
            sb.append(",");
        }
        sb.append(strs[left]);
        System.out.println(sb.toString());
    }
}