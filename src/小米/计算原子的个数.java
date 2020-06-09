package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class 计算原子的个数 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        Stack<Map<String, Integer>> stack = new Stack<>(); //map记录每一组的元素个数
        int i = 0, n = s.length();
        stack.push(new TreeMap<>());
        while(i<n) {
            if(s.charAt(i)=='(') {
                stack.push(new TreeMap<>());
                i++;
            } else if(s.charAt(i)==')') {
                Map<String, Integer> map = stack.pop(); //合并到上一个map中
                int start = ++i;
                while(i<n&&Character.isDigit(s.charAt(i))) {
                    i++;
                }
                int value = i==start ? 1 : Integer.parseInt(s.substring(start, i));
                for(String str : map.keySet()) {
                    stack.peek().put(str, stack.peek().getOrDefault(str, 0)+value*map.get(str));
                }
            } else {
                int start = i++;
                while(i<n&&Character.isLowerCase(s.charAt(i))) {
                    i++;
                }
                String str = s.substring(start, i);
                start = i;
                while(i<n&&Character.isDigit(s.charAt(i))) {
                    i++;
                }
                int value = i==start? 1 : Integer.parseInt(s.substring(start, i));
                stack.peek().put(str, stack.peek().getOrDefault(str, 0)+value);
            }
        }
        Map<String, Integer> map = stack.pop();
        StringBuffer sb = new StringBuffer();
        for(String str : map.keySet()) {
            int value = map.get(str);
            if(value==1) sb.append(str);
            else sb.append(str+value+"");
        }
        System.out.println(sb.toString());
    }

}
