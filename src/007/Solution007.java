public class Solution007 {

    public static int reverse(int x) {
        boolean neg = false;
        if (x < 0) {
            neg = true;
            x = -x;
        }
        try {
            int ans = Integer.parseInt(new StringBuilder(String.valueOf(x)).reverse().toString());
            if (neg) ans = -ans;
            return ans;
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(1534236469));
        System.out.println(reverse(2147483647));
    }
}
