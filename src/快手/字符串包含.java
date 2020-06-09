package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 字符串包含 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while( (s=bf.readLine())!=null  ) {
            String[] strs = s.split(" ");
            String s1 = strs[0];
            String s2 = strs[1];
            if(s1.length()>s2.length()) {
                System.out.println(s1.contains(s2)? 1 : 0);
            } else {
                System.out.println(s2.contains(s1)? 1 : 0);
            }
        }
    }
}
