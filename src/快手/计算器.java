package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 计算器 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int n = s.length();
        int index = 0;
        Stack<String> stack = new Stack<>();
        while(index<n) {
            String ss = s.substring(index, index+1);
            if(ss.equals("(")||ss.equals("+")||ss.equals("-")||ss.equals("*")) {
                stack.push(ss);
                index++;
            } else if(ss.equals(")")) {
                index++;
                int sum = Integer.parseInt(stack.pop());
                String str = null;
                while(!stack.peek().equals("(")) {
                    str = stack.pop();
                    if(str.equals("+")) {
                        sum  = sum+Integer.parseInt(stack.pop());
                    }
                }
                stack.pop();
                ss = sum+"";
                MyPush(stack, ss);
            } else {
                int temp = index;
                while(index<n&&Character.isDigit(s.charAt(index))) {
                    index++;
                }
                ss = s.substring(temp, index);
                MyPush(stack, ss);
            }
        }
        int sum = Integer.parseInt(stack.pop());
        String str = null;
        while(!stack.isEmpty()) {
            str = stack.pop();
            if(str.equals("+")) {
                sum  = sum+Integer.parseInt(stack.pop());
            }
        }
        System.out.println(sum);
    }
    private static void MyPush(Stack<String> stack, String ss) {
        if(!stack.isEmpty()&&stack.peek().equals("*")) {
            stack.pop();
            int a = Integer.parseInt(stack.pop());
            int b = Integer.parseInt(ss)*a;
            ss = b+"";
        } else if(!stack.isEmpty()&&stack.peek().equals("-")) { //保证栈里面都是加号
            stack.pop();
            stack.push("+");
            int a = -Integer.parseInt(ss);
            ss = a+"";
        }
        stack.push(ss);
    }
}
