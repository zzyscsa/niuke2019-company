package 快手;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 今年第几天 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int[] arr = {0,31,59,90,120,151,181,212,243,273,304,334,365};
        while( (s=bf.readLine())!=null ) {
            String[] strs = s.split(" ");
            int year = Integer.parseInt(strs[0]);
            int month = Integer.parseInt(strs[1]);
            int day = Integer.parseInt(strs[2]);
            if(month<=2) {
                System.out.println(arr[month-1]+day);
            } else {
                if(year%400==0||(year%4==0&&year%100!=0))
                    System.out.println(arr[month-1]+day+1);
                else
                    System.out.println(arr[month-1]+day);
            }
        }
    }
}
