package 哔哩哔哩;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class 给定一个整数数组判断其中是否有3个数和为N {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(",");
        String[] strss = strs[0].split(" ");
        int N = Integer.parseInt(strs[1]);
        int[] arr = new int[strss.length];
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strss[i]);
            sum += arr[i];
        }
        if(sum<N) {
            System.out.println("False");
            return;
        }

        Arrays.sort(arr);
        for(int i = 0; i < arr.length-1; i++) {
            int left = i+1;
            int right = arr.length-1;
            if(arr[i]>=N) {
                System.out.println("False");
                return;
            }
            while(left<right) {
                int temp = arr[i]+arr[left]+arr[right];
                if(temp==N) {
                    System.out.println("True");
                    return;
                }
                else if(temp<N) {
                    left++;

                } else {
                    right--;
                }
            }
        }
        System.out.println("False");
    }
}