package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 嗯ipv4地址白名单 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        String[] strs;
        HashSet<String> set = new HashSet<>();
        while( !(str=bf.readLine()).equals("end") ) {
            strs = str.split(":");
            String s = strs[1];
            switch(strs[0]) {
                case "i":
                    set.add(s);
                    System.out.println("ok");
                    break;
                case "d":
                    set.remove(s);
                    System.out.println("ok");
                    break;
                case "s":
                    System.out.println(set.contains(s));
                    break;
            }
        }
    }
}
