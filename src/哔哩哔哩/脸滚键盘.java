package 哔哩哔哩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;


public class 脸滚键盘 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while( (str=bf.readLine())!=null ) {
            String[] strs = str.split(" ");
            int k = Integer.parseInt(strs[0]);
            String s = str.substring(strs[0].length()+1, str.length());
            System.out.println(func(s, k));
        }
    }
    private static String func(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i))==1&&k==1) {
                return "["+s.charAt(i)+"]";
            } else if(map.get(s.charAt(i))==1)
                k--;
        }
        return "Myon~";
    }
}