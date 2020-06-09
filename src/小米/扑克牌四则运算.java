package 小米;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 扑克牌四则运算 {
    static int m = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        m = Integer.parseInt(bf.readLine().trim());
        int a = Integer.parseInt(strs[0]);
        int b = Integer.parseInt(strs[1]);
        int c = Integer.parseInt(strs[2]);
        int d = Integer.parseInt(strs[3]);
        System.out.println(fun2(a,b,c,d));
    }
    private static boolean fun(int a, int b, int c, int d) {
        return ((a + b + c + d == m) || (a + b + c - d == m) || (a + b + c * d == m) || (a + b + c / d == m)
                || (a + b - c + d == m) || (a + b - c - d == m) || (a + b - c * d == m) || (a + b - c / d == m)
                || (a + b * c + d == m) || (a + b * c - d == m) || (a + b * c * d == m) || (a + b * c / d == m)
                || (a + b / c + d == m) || (a + b / c - d == m) || (a + b / c * d == m) || (a + b / c / d == m)
                || (a - b + c + d == m) || (a - b + c - d == m) || (a - b + c * d == m) || (a - b + c / d == m)
                || (a - b - c + d == m) || (a - b - c - d == m) || (a - b - c * d == m) || (a - b - c / d == m)
                || (a - b * c + d == m) || (a - b * c - d == m) || (a - b * c * d == m) || (a - b * c / d == m)
                || (a - b / c + d == m) || (a - b / c - d == m) || (a - b / c * d == m) || (a - b / c / d == m)
                || (a * b + c + d == m) || (a * b + c - d == m) || (a * b + c * d == m) || (a * b + c / d == m)
                || (a * b - c + d == m) || (a * b - c - d == m) || (a * b - c * d == m) || (a * b - c / d == m)
                || (a * b * c + d == m) || (a * b * c - d == m) || (a * b * c * d == m) || (a * b * c / d == m)
                || (a * b / c + d == m) || (a * b / c - d == m) || (a * b / c * d == m) || (a * b / c / d == m)
                || (a / b + c + d == m) || (a / b + c - d == m) || (a / b + c * d == m) || (a / b + c / d == m)
                || (a / b - c + d == m) || (a / b - c - d == m) || (a / b - c * d == m) || (a / b - c / d == m)
                || (a / b * c + d == m) || (a / b * c - d == m) || (a / b * c * d == m) || (a / b * c / d == m)
                || (a / b / c + d == m) || (a / b / c - d == m) || (a / b / c * d == m) || (a / b / c / d == m));
    }
    private static int fun2(int a, int b, int c, int d) {
        if (fun(a, b, c, d) || fun(a, b, d, c) || fun(a, c, b, d)
                || fun(a, c, d, b) || fun(a, d, b, c) || fun(a, d, c, b)
                || fun(b, a, c, d) || fun(b, a, d, c) || fun(b, c, a, d)
                || fun(b, c, d, a) || fun(b, d, a, c) || fun(b, d, c, a)
                || fun(c, a, b, d) || fun(c, a, d, b) || fun(c, b, a, d)
                || fun(c, b, d, a) || fun(c, d, a, b) || fun(c, d, b, a)
                || fun(d, a, b, c) || fun(d, a, c, b) || fun(d, b, a, c)
                || fun(d, b, c, a) || fun(d, c, a, b) || fun(d, c, b, a)) {
            return 1;
        }
        return 0;
    }

}
