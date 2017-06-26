public class Solution003 {

    static int lengthOfLongestSubstring(String s) {
        if ("".equals(s)) return 0;
        boolean[] flag = new boolean[128];
        int ans = 1;
        int head = 0;
        int tail = 1;
        flag[(int)s.charAt(head)] = true;
        while (tail < s.length()) {
            int i = (int)s.charAt(tail);
            if (!flag[i]) {
                flag[i] = true;
                tail++;
                ans = Math.max(ans, tail - head);
            } else {
                while (s.charAt(head) != s.charAt(tail)) {
                    flag[(int)s.charAt(head)] = false;
                    head++;
                }
                head++;
                tail++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}
