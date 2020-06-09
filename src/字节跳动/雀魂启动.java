package 字节跳动;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 雀魂启动 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        int[] arr = new int[14];
        int[] cnt = new int[10];
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < 13; i++) {
            arr[i] = Integer.parseInt(strs[i]);
            cnt[arr[i]]++;
        }
        for(int i = 1; i <= 9; i++) {
            int[] temp = new int[10];
            if(cnt[i]>=4) continue; //每个数字一共就四张牌
            System.arraycopy(cnt, 0, temp, 0, 10);
            temp[i]++;
            if(func(temp)) {
                sb.append(i+" ");
            } else {
                temp[i]--;
            }
        }
        if(sb.length()==0) System.out.println(0);
        else System.out.println(sb.delete(sb.length()-1, sb.length()).toString());
    }
    //选择雀头
    private static boolean func(int[] cnt) {
        int[] temp = new int[10];
        for(int i = 1; i <= 9; i++) {
            if(cnt[i]>=2) {
                System.arraycopy(cnt, 0, temp, 0, 10);
                temp[i] -= 2;
                if(dfs(temp, 4)) {
                    return true;
                }
            }
        }
        return false;
    }
    //判断剩余的牌是否构成4对
    private static boolean dfs(int[] cnt, int n) {
        if(n==0) return true;
        //1~9，每张牌尝试三张或者顺子
        for(int i = 1; i <= 9; i++) {
            if(cnt[i]>=3) {
                cnt[i] -= 3;
                boolean flag = dfs(cnt, n-1);
                cnt[i] += 3;
                if(flag) return true;
            }
            if(i<=7 && cnt[i]>0 && cnt[i+1]>0 && cnt[i+2]>0) {
                cnt[i]--;
                cnt[i+1]--;
                cnt[i+2]--;
                boolean flag = dfs(cnt, n-1);
                cnt[i]++;
                cnt[i+1]++;
                cnt[i+2]++;
                if(flag) return true;
            }
        }

        return false;
    }
}