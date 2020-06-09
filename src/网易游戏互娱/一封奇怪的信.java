package 网易游戏互娱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 一封奇怪的信 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        int[] arr = new int[26];
        for(int i = 0; i < 26; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        String s = bf.readLine();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int cnt = 1;
        int temp = 0;
        for(int i = 0; i < s.length(); i++) {
            int len = arr[s.charAt(i)-'a'];
            if(temp+len>100) {
                cnt++;
                temp = len;
                list.add(len);
            } else {
                temp += len;
                list.set(cnt-1, list.get(cnt-1)+len);
            }
        }
        System.out.println(cnt+" "+list.get(list.size()-1));
    }
}
