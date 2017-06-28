public class Solution006 {

    public static String convert(String s, int numRows) {
        if (s.length() <= 2 || numRows == 1) return s;
        String[] ans = new String[numRows];
        char[] chars = s.toCharArray();
        int row = 0;
        int op = 1;
        int i = 0;
        for (int j=0;j<numRows;j++) ans[j] = "";
        while (i < s.length()) {
            ans[row] += chars[i];
            if (row + op < 0 || row + op >= numRows) {
                op = -op;
            }
            row += op;
            i++;
        }
        String res = "";
        for (int j=0;j<numRows;j++) res += ans[j];
        return res;
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
