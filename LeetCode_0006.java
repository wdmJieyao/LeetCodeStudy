
import java.util.ArrayList;

/**
 * @author LiJieYao
 * @description 力扣第六题
 * @date 2021/4/28 18:54
 */
public class LeetCode_0006 {

/*      将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
        比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
        P   A   H   N
        A P L S I I G
        Y   I   R
*/

    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
    }

    public static String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }

        ArrayList<StringBuilder> builder = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            builder.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            builder.get(i).append(c);
            // 临界条件
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder row : builder) {
            res.append(row);
        }
        return res.toString();
    }
}
