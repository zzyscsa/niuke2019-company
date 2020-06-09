package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 获取n维数组的最大深度 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        Stack<Character> stack = new Stack<>();
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch=='[') {
                stack.push(ch);
                res = Math.max(res, stack.size());
            } else if(ch==']') {
                stack.pop();
            }
        }
        System.out.println(res);
    }
}
