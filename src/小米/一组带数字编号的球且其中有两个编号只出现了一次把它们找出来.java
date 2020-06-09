package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 一组带数字编号的球且其中有两个编号只出现了一次把它们找出来 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        List<Integer> list = new ArrayList<>();
        int a = 0, b = 0, c = 0;
        while ((str = bf.readLine()) != null){
            int num = Integer.parseInt(str);
            c ^= num;
            list.add(num);
        }
        c = Integer.highestOneBit(c);
        for(int i : list) {
            if( (c&i)==0 ) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
        System.out.print(a+" ");
        System.out.println(b);
    }
}
