package 百度;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 猜数 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        long x = Long.parseLong(strs[0]);
        long y = Long.parseLong(strs[1]);
        if(2*x<y)
            System.out.println(0);
        else {
            long mid = y/2;
            if(x>=y)
                System.out.println(y-1-mid);
            else
                System.out.println(Math.abs(x-mid));
        }
    }
}