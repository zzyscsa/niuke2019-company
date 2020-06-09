package 哔哩哔哩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * 金闪闪死后，红A拿到了王之财宝，里面有n个武器，长度各不相同。红A发现，拿其中三件武器首尾相接，组成一个三角形，进行召唤仪式，就可以召唤出一个山寨金闪闪。
 * （例如，三件武器长度为10、15、20，可以召唤成功。若长度为10、11、30，首尾相接无法组成三角形，召唤失败。）
 * 红A于是开了一个金闪闪专卖店。他把王之财宝排成一排，每个客人会随机抽取到一个区间[l,r],客人可以选取区间里的三件武器进行召唤（客人都很聪慧，如果能找出来合适的武器，一定不会放过）。
 * 召唤结束后，客人要把武器原样放回去。m个客人光顾以后，红A害怕过多的金闪闪愉悦太多男人，于是找到了你，希望你帮他统计出有多少山寨金闪闪被召唤出来。
 *
 * 输入描述:
第一行武器数量:n <= 1*10^7
第二行空格分隔的n个int，表示每件武器的长度。
第三行顾客数量：m <= 1*10^6
后面m行，每行两个int l，r，表示每个客人被分配到的区间。（l<r）
输出描述:
山寨金闪闪数量。


5
1 10 100 95 101
4
1 3
2 4
2 5
3 5


3
 * */

public class 山寨金闪闪 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        String[] strs = bf.readLine().split(" ");
        int[] arr = new int[n];
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        int m = Integer.parseInt(bf.readLine().trim());
        for(int i = 0; i < m; i++) {
            strs = bf.readLine().split(" ");
            int l = Integer.parseInt(strs[0]);
            int r = Integer.parseInt(strs[1]);
            //如果数字很多，就很容易构造出三角形，那么极端情况就是1,1,2,3,5,8......
            //就是斐波那契数列，当写到第47个的时候，刚好超出int的范围了
            if(r-l+1>=47) {
                cnt++;
                continue;
            }
            if(func(arr, l-1, r-1))
                cnt++;
        }
        System.out.println(cnt);
    }
    private static boolean func(int[] arr, int l, int r) {
        int[] temp = new int[r-l+1];
        System.arraycopy(arr, l, temp, 0, r-l+1);
        Arrays.sort(temp);
        for(int i = 0; i < temp.length-2; i++) {
            if(temp[i]+temp[i+1]>temp[i+2])
                return true;
        }
        return false;
    }
}