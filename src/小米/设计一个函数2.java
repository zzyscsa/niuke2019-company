package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 设计一个函数2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(",");
        List<String> list = new ArrayList<>();
        for(int i = 0; i <strs.length; i++) {
            if(strs[i].contains("[")) {
                String s = strs[i-1];
                String[] ss = s.split(" ");
                String res = ss[ss.length-1].substring(1, ss[ss.length-1].length()-1);
                list.add("\""+res+"\"");
            }
        }
        System.out.print("[");
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if(i!=list.size()-1)
                System.out.print(",");
        }
        System.out.print("]");
    }

}
