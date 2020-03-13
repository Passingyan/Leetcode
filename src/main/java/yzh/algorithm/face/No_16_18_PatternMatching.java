package yzh.algorithm.face;

/**
 * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入： pattern = "abba", value = "dogcatcatdog"
 * 输出： true
 * 示例 2：
 * <p>
 * 输入： pattern = "abba", value = "dogcatcatfish"
 * 输出： false
 * 示例 3：
 * <p>
 * 输入： pattern = "aaaa", value = "dogcatcatdog"
 * 输出： false
 * <p>
 * 示例 4：
 * <p>
 * 输入： pattern = "abba", value = "dogdogdogdog"
 * 输出： true
 * 解释： "a"="dogdog",b=""，反之也符合规则
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pattern-matching-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No_16_18_PatternMatching {

    public static void main(String[] args) {
        String pattern = "bbbaa";
        String value = "xxxxxxy";
        System.out.println(new No_16_18_PatternMatching().patternMatching(pattern, value));
    }

    public boolean patternMatching(String pattern, String value) {
        if (pattern.length() == 0 && value.length() == 0) return true;
        if (pattern.length() == 0) return false;
        char[] ch = pattern.toCharArray();
        int bb = 0;
        int a = 1;
        int b = 0;
        for (int i = 1; i < ch.length; i++) {
            if (ch[i] == ch[0]) a++;
            else b++;
        }
        if (value.length() == 0) {
            return a * b == 0;
        }
        for (int i = 0; i <= value.length() / a; i++) {
            if (b == 0 && i * a != value.length()) continue;
            else if (b == 0) bb = 0;
            else bb = (value.length() - a * i) / b;
            String temp = getABString(ch, i, bb, value);
            if (temp != null && value.equals(temp)) return true;
        }
        return false;
    }

    public String getABString(char[] ch, int aa, int bb, String value) {
        StringBuilder sb = new StringBuilder();
        String a = value.substring(0, aa);
        String b = null;
        int index = 0;
        for (char c : ch) {
            if (c == ch[0]) {
                sb.append(a);
                index += aa;
            } else {
                if (b == null) b = value.substring(index, index + bb);
                sb.append(b);
            }

        }
        if (a.equals(b)) return null;
        return sb.toString();
    }
}
