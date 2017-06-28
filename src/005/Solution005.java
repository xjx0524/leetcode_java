public class Solution005 {

    public static String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        int max = 1;
        int ans = 0;
        for (int i=0;i<s.length()-1;i++) {
            int l = i;
            int r = i+1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (r-l-1 > max) {
                max = r - l - 1;
                ans = l + 1;
            }
        }
        for (int i=1;i<=s.length()-2;i++) {
            int l = i-1;
            int r = i+1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (r-l-1 > max) {
                max = r - l - 1;
                ans = l + 1;
            }
        }
        return s.substring(ans, ans + max);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }
}
