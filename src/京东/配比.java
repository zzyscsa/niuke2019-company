package 京东;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 配比 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        double v = Integer.parseInt(strs[1]);
        String[] strs1 = bf.readLine().split(" ");
        String[] strs2 = bf.readLine().split(" ");
        int[] arr1 = new int[n]; //配比
        int[] arr2 = new int[n]; //原料数
        double min = Double.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(strs1[i]);
            arr2[i] = Integer.parseInt(strs2[i]);
            min = Math.min(min, (double)arr2[i]/arr1[i]);
        }
        double res = 0;
        for(int i = 0; i < n; i++) {
            res += min*arr1[i];
        }
        System.out.println(v<res ? String.format("%.4f", v) : String.format("%.4f", res));
    }
}
