

/**
 * @author LiJieYao
 * @description 力扣第六题
 * @date 2021/4/28 18:54
 */
public class LeetCode_0007 {

/*      给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

        如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。

        假设环境不允许存储 64 位整数（有符号或无符号）。
        输入：x = 123
        输出：321
*/

    public static void main(String[] args) {
        System.out.println(reverse(5421));
        // System.out.println(54321 % 10);
    }

    public static int reverse(int x) {
        String value = String.valueOf(x)
            .replace("-", "")
            .trim();
        double intMax = Math.pow(2D, 31D);
        StringBuilder builder = x < 0 ? new StringBuilder("-") : new StringBuilder();
        char[] chars = value.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            builder.append(chars[i]);
        }
        Long result = Long.parseLong(builder.toString());
        if (result > intMax - 1 || result < -intMax) {
            return 0;
        }
        return result.intValue();
    }

    /**
     * 大佬优化版本
     */
    public static int reverse2(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }


}
