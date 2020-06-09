package 网易游戏互娱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 字符迷阵 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine().trim());
        for(int i = 0; i < t; i ++) {
            String[] strs = bf.readLine().split(" ");
            int m = Integer.parseInt(strs[0]); //行
            int n = Integer.parseInt(strs[1]); //列
            char[][] arr = new char[m][n];
            for(int j = 0; j < m; j++) {
                String s = bf.readLine();
                char[] c = s.toCharArray();
                arr[j] = c;
            }
            String word = bf.readLine();
            int cnt = 0;
            for(int x = 0; x < m; x++) {
                for(int y = 0; y < n; y++) {
                    if(arr[x][y]==word.charAt(0)) {
                        //往右
                        int index = y+1;
                        boolean flag = true;
                        for(int k = 1; k < word.length(); k++) {
                            if(index>=n) {
                                flag = false;
                                break;
                            }
                            if(arr[x][index]!=word.charAt(k)) {
                                flag = false;
                                break;
                            }
                            index++;
                        }
                        if(flag) cnt++;
                        //往下
                        index = x+1;
                        flag = true;
                        for(int k = 1; k < word.length(); k++) {
                            if(index>=m) {
                                flag = false;
                                break;
                            }
                            if(arr[index][y]!=word.charAt(k)) {
                                flag = false;
                                break;
                            }
                            index++;
                        }
                        if(flag) cnt++;
                        //往右下
                        index = x+1;
                        int index1 = y+1;
                        flag = true;
                        for(int k = 1; k < word.length(); k++) {
                            if(index>=m||index1>=n) {
                                flag = false;
                                break;
                            }
                            if(arr[index][index1]!=word.charAt(k)) {
                                flag = false;
                                break;
                            }
                            index++;
                            index1++;
                        }
                        if(flag) cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
