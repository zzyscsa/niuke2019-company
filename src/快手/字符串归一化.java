package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 字符串归一化 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)-'a']++;
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < 26; i++) {
            if(arr[i]!=0) {
                sb.append(String.valueOf((char)(i+'a'))+arr[i]);
            }
        }
        System.out.println(sb);
    }
}
