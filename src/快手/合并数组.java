package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 合并数组 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s1 = bf.readLine();
        String s2 = bf.readLine();
        if(s2==null) {
            System.out.println(s1);
            return;
        }
        String[] strs1 = s1.split(",");
        String[] strs2 = s2.split(",");
        StringBuffer sb = new StringBuffer();
        int i = 0, j = 0;
        int len1 = strs1.length;
        int len2 = strs2.length;
        while(i<len1&&j<len2) {
            if(Integer.parseInt(strs1[i])<Integer.parseInt(strs2[j])) {
                sb.append(strs1[i]+",");
                i++;
            } else {
                sb.append(strs2[j]+",");
                j++;
            }
        }
        while(i<len1) {
            sb.append(strs1[i]+",");
            i++;
        }
        while(j<len2) {
            sb.append(strs2[j]+",");
            j++;
        }
        System.out.println(sb.deleteCharAt(sb.length()-1));
    }
}
