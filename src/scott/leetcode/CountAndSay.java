package scott.leetcode;

//The count-and-say sequence is the sequence of integers beginning as follows:
//1, 11, 21, 1211, 111221, ...
//
//1 is read off as "one 1" or 11.
//11 is read off as "two 1s" or 21.
//21 is read off as "one 2, then one 1" or 1211.
//Given an integer n, generate the nth sequence.

/**
 * @author Scott Xing
 */
public class CountAndSay {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(15));
    }

    public String countAndSay(int n) {
        String result = "1";
        if (n > 1) {
            for (int i = 1; i < n; i++) {
                result = calcNext(result);
            }
        }
        return result;
    }

    private String calcNext(String s) {
        StringBuffer res = new StringBuffer();
        char temp = s.charAt(0);
        int num = 1;

        for (int i = 1; i < s.length(); i++) {
            if (temp == s.charAt(i)) {
                num++;
            } else {
                res.append(num).append(temp);
                num = 1;
                temp = s.charAt(i);
            }
        }
        res.append(num).append(temp);
        return res.toString();
    }
}
