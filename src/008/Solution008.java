public class Solution008 {

    public static int myAtoi(String str) {
        if (str.length() == 0) return 0;
        char[] chars = str.toCharArray();
        int i = 0;
        while (chars[i] == ' ') i++;
        int sign = 1;
        if (chars[i] == '-' || chars[i] == '+') {
            if (chars[i] == '-') sign = -1;
            i++;
        }
        long res = 0;
        while (i < str.length()) {
            if ((int)chars[i] < (int)'0' || (int)chars[i] > (int)'9') break;
            res = res * 10 + sign * ((int)chars[i] - (int)'0');
            if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("2147483648"));
    }
}
