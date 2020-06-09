package 哔哩哔哩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;


public class 简单表达式计算 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while(true) {
            str = bf.readLine();
            if(str.equals("END")) break;
            System.out.println(cal(str));
        }
    }
    private static int cal(String str) {
        int sum = 0;
        Stack<String> stack = new Stack<>();
        stack.push("+");
        for(int i = 0; i < str.length();) {
            int s = i;
            char cc = str.charAt(i);
            if(cc=='+'||cc=='*'||cc=='-') {
                stack.push(String.valueOf(cc));
                i++;
                continue;
            }
            while(i<str.length()&&Character.isDigit(str.charAt(i))) {
                i++;
            }
            String c = str.substring(s, i);
            if(stack.peek().equals("*")) {
                stack.pop();
                int t = Integer.parseInt(stack.pop())*Integer.parseInt(c);
                stack.push(t+"");
            } else {
                stack.push(c);
            }

        }
        while(!stack.isEmpty()) {
            int a = Integer.parseInt(stack.pop());
            String c = stack.pop();
            if(c.equals("+"))
                sum += a;
            else
                sum -= a;
        }

        return sum;

    }
}