package 哔哩哔哩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class 红茶 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine().trim());
        String[] strs = bf.readLine().split(" ");
        int m = Integer.parseInt(bf.readLine().trim());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(strs[i]);

        Arrays.sort(arr);
        int left = 0;
        int right = arr.length-1;
        boolean flag = false;
        while(left<right) {
            int temp = arr[left]+arr[right];
            if(temp<m) {
                left++;
            } else if(temp>m) {
                right--;
            } else {
                flag = true;
                System.out.println(arr[left]+" "+arr[right]);
                left++;
            }
        }
        if(!flag)
            System.out.println("NO");
    }
}