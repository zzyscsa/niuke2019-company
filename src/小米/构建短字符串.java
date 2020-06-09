package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 构建短字符串 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        String s1 = strs[0];
        String s2 = strs[1];
        int[] arr = new int[26];
        for(int i = 0; i < s2.length(); i++) {
            arr[s2.charAt(i)-'a']++;
        }
        for(int i = 0; i < s1.length(); i++) {
            if(arr[s1.charAt(i)-'a']==0) {
                System.out.println(false);
                return;
            }
            arr[s1.charAt(i)-'a']--;
        }
        System.out.println(true);
    }
}
