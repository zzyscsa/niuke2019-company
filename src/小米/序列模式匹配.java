package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 序列模式匹配 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs;
        String str = null;
        while( (str=bf.readLine())!=null ) {
            int start = -1;
            int end = -1;
            strs = str.split(" ");
            String text = strs[0];
            String pattern = strs[1];
            for(int i = 0; i <= text.length()-pattern.length(); i++) {
                if(text.charAt(i)==pattern.charAt(0)) {
                    int index = 0;
                    int t = i;
                    while(t<text.length()) {
                        if(text.charAt(t)==pattern.charAt(index)) {
                            index++;
                        }
                        t++;
                        if(index==pattern.length()) {
                            if(start==-1&&end==-1) {
                                start = i;
                                end = t-1;
                            } else {
                                if(t-1-i<end-start) {
                                    start = i;
                                    end = t-1;
                                }
                            }
                            break;
                        }
                    }
                }
            }
            System.out.println(start+" "+end);
        }
    }
}
