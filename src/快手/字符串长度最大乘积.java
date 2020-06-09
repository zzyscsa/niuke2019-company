package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 字符串长度最大乘积 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        String[] strs = str.substring(1, str.length()-1).split(",");
        int max = 0;
        for(int i = 0; i < strs.length; i++) {
            for(int j = i+1; j < strs.length; j++) {
                String s1 = strs[i].substring(1, strs[i].length()-1);
                String s2 = strs[j].substring(1, strs[j].length()-1);
                boolean flag = true;
                if(s1.length()<=s2.length()) {
                    if(!func(s1, s2))
                        flag = false;
                } else {
                    if(!func(s2, s1))
                        flag = false;
                }
                if(flag) {
                    max = Math.max(max, s1.length()*s2.length());
                }
            }
        }
        System.out.println(max);
    }
    private static boolean func(String s1, String s2) {
        for(int k = 0; k < s1.length(); k++) {
            if(s2.contains(s1.substring(k, k+1))) {
                return false;
            }
        }
        return true;
    }
}
