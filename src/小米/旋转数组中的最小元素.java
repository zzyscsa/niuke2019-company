package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 旋转数组中的最小元素 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        int[] arr = new int[strs.length];
        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(strs[i]);
        int left = 0, right = strs.length-1;
        while(left<right) {
            int mid = left+(right-left)/2;
            if(arr[mid]>arr[right]) { //最小元素在右半部分
                left = mid+1;
            } else if(arr[mid]<arr[right]) { //最小元素在左半部分
                right = mid;
            } else {
                right = right-1;
            }
        }// 2 2 2 2 2 2 2 2 2 2
        System.out.println(arr[left]);
    }
}
