import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author LiJieYao
 * @date 2021/4/19 22:29
 * @description LeetCode 第三题
 */
public class LeetCode_0003 {


    /**
     * 暴力破解法  时间复杂度高  重复度高
     */
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        List<Character> currentChar = new ArrayList<>();
        int length = chars.length;
        int result = 0;

        // 外层遍历
        for (int i = 0; i < length; i++) {
            // 获取当前子串最大长度
            for (int j = i; j < length; j++) {
                if (currentChar.contains(chars[j])) {
                    break;
                }
                currentChar.add(chars[j]);
            }
            if (result < currentChar.size()) {
                // 当前遍历顺序最长
                if (currentChar.size() == length - i) {
                    return currentChar.size();
                }
                // 记录子串长度
                result = currentChar.size();
            }
            currentChar.clear();
        }
        return result;
    }

    /**
     * 官方题解
     * 1、不会有重复
     */
    public static int lengthOfLongestSubstring2(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "lijieyao";
        System.out.println(lengthOfLongestSubstring2(s));
    }
}
