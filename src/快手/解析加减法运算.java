package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 解析加减法运算 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        Queue<Integer> queue = new LinkedList<>();
        char c = s.charAt(0)=='-' ? '-' : '+';
        int i = s.charAt(0)=='-' ? 1 : 0;
        int res = 0;
        for(; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch=='+'||ch=='-') {
                int temp = 0;
                while(!queue.isEmpty()) {
                    temp = temp*10+queue.poll();
                }
                if(c=='+') res += temp;
                else res -= temp;
                c = ch;
            } else {
                queue.add((int)(ch-'0'));
            }
        }
        int temp = 0;
        while(!queue.isEmpty()) {
            temp = temp*10+queue.poll();
        }
        if(c=='+') res += temp;
        else res -= temp;
        System.out.println(res);
    }
}
