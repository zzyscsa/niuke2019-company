package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 查找无重复最长子串 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int left = 0, right = 0, max = 1;
        int n = s.length();
        if(n==0||n==1) {
            System.out.println(n);
            return;
        }
        Set<Character> set = new HashSet<>();

        while(right<n) {
            char ch = s.charAt(right);
            if(!set.contains(ch)) {
                set.add(ch);
                max = right-left+1;
                right++;
            } else {
                while(set.contains(ch)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(ch);
                right++;
            }
        }
        max = Math.max(max, right-left);
        System.out.println(max);
    }
}
