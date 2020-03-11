package yzh.algorithm.face;

/**
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 * <p>
 * 示例1:
 * <p>
 * 输入："Mr John Smith    ", 13
 * 输出："Mr%20John%20Smith"
 * 示例2:
 * <p>
 * 输入："               ", 5
 * 输出："%20%20%20%20%20"
 */
public class No_01_03_URL_ReplaceSpaces {
    public String replaceSpaces(String S, int length) {
        if (length == 0 || S.length() == 0) return "";
        String ss = S.substring(0, length);
        return ss.replace(" ", "%20");
    }
}
