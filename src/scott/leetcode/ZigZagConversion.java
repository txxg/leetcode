package scott.leetcode;

public class ZigZagConversion {

    public static void main(String[] args) {
        System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 4));
    }

    public String convert(String s, int nRows) {
        if (s == null || s.length() <= 1 || nRows <= 1) {
            return s;
        }
        StringBuffer result = new StringBuffer();
        int length = s.length();
        int u = nRows * 2 - 2;
        int a = length % u;
        a = a > nRows ? (a - nRows + 1) : 1;
        char matrix[][] = new char[nRows][(length / u) * (nRows - 1) + a];
        int h = 0, v = 0;

        for (int i = 0; i < s.length(); i++) {
            h = i % u < nRows ? i % u : (nRows - (i % u - nRows) - 2);
            v = (u - nRows + 1) * (i / u) + (i % u < nRows ? 0 : (i % u - nRows + 1));
            matrix[h][v] = s.charAt(i);
        }

        for (int m = 0; m < matrix.length; m++) {
            for (int n = 0; n < matrix[m].length; n++) {
                if (matrix[m][n] != '\u0000') {
                    result.append(matrix[m][n]);
                }
            }
        }

        return result.toString();
    }
}
