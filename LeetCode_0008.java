package com.lijieyao.basedepend.entity;

/**
 * @author LiJieYao
 * @description 力扣第八题
 * @date 2021/5/2 1:52 下午
 */
public class LeetCode_0008 {

    /*
        请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。

        函数 myAtoi(string s) 的算法如下：

        读入字符串并丢弃无用的前导空格
        检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
        读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
        将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
        如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
        返回整数作为最终结果。
        注意：

        本题中的空白字符只包括空格字符 ' ' 。
        除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
        提示：
        0 <= s.length <= 200
        s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成

        输入：s = "-91283472332"
        输出：-2147483648
        解释：
        第 1 步："-91283472332"（当前没有读入字符，因为没有前导空格）
                 ^
        第 2 步："-91283472332"（读入 '-' 字符，所以结果应该是负数）
                  ^
        第 3 步："-91283472332"（读入 "91283472332"）
                             ^
        解析得到整数 -91283472332 。
        由于 -91283472332 小于范围 [-231, 231 - 1] 的下界，最终结果被截断为 -231 = -2147483648 。
     */

    public static void main(String[] args) {
        System.out.println(myAtoi("1"));
    }

    public static int myAtoi(String s) {
        // 去空格
        String trim = s.trim();
        if (trim.length() < 1) {
            return 0;
        }
        // 获取有效数字
        char[] chars = trim.toCharArray();
        // 校验首字符是否符合要求
        char first = chars[0];
        if (!isEffectFirstNum(first)) {
            return 0;
        }
        // 遍历取出数字
        StringBuilder builder = new StringBuilder()
            .append(first);
        for (int i = 1; i < chars.length; i++) {
            char currentChar = chars[i];
            if (isEffectNum(currentChar)) {
                builder.append(currentChar);
                continue;
            }

            if (currentChar == 46 && i + 1 < chars.length && isEffectNum(chars[i + 1])) {
                builder.append(currentChar);
                continue;
            }

            break;
        }
        String stringNum = builder.toString();
        if (stringNum.length() == 1 && (stringNum.equals("+") || stringNum.equals("-"))) {
            return 0;
        }

        double doubleNum = Double.parseDouble(stringNum);
        if (doubleNum > Integer.MAX_VALUE || doubleNum < Integer.MIN_VALUE) {
            return doubleNum > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int) doubleNum;
    }

    private static boolean isEffectFirstNum(char first) {
        return first == 43 || first == 45 || (first >= 48 && first <= 57);
    }

    private static boolean isEffectNum(char first) {
        return (first >= 48 && first <= 57);
    }

    /**
     *  优化版
     */
    public int myAtoi2(String s) {
        s = s.trim();
        if (s.length() < 1) return 0;
        char[] a = s.toCharArray();
        long sum = 0;
        if (a[0] == '-' || a[0] == '+' || (a[0] >= '0' && a[0] <= '9')) {
            for (int i = 0; i < a.length; i++) {
                if ((a[i] == '-' || a[i] == '+') && i == 0) continue;
                if (a[i] >= '0' && a[i] <= '9') {
                    sum = (a[i] - '0') + sum * 10;
                } else break;
                if (-sum <= -2147483648 && a[0] == '-') return -2147483648;
                if (sum >= 2147483647 && a[0] != '-') return 2147483647;
            }
        } else return 0;
        return a[0] == '-' ? (int) -sum : (int) sum;
    }
}
