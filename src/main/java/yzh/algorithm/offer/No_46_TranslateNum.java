package yzh.algorithm.offer;

/**
 * @author yongzh
 * @date 2021/8/17
 */
public class No_46_TranslateNum {
    /**
     * 解题思路：
     * 简单理解，字符翻译存在两种，一是单独翻译，则翻译种数同前一个字符相同，
     * 另一中是和前一个字符连在一起翻译，则翻译种数同前前一个字符相同。
     * 则从头到当前字符为止，翻译种树有 方式1 + 方式2，前提是方式2的字符拼接是在10~25之间
     */
    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        int a_2 = 1;
        int a_1 = 1;
        int index = 1;
        int temp;
        while (index < numStr.length()) {
            temp = Integer.parseInt(numStr.substring(index - 1, index + 1));
            temp = (temp >= 10 && temp <= 25) ? a_1 + a_2 : a_1;
            a_2 = a_1;
            a_1 = temp;
            index++;
        }
        return a_1;
    }

    public static void main(String[] args) {
        No_46_TranslateNum no_46_translateNum = new No_46_TranslateNum();
        System.out.println(no_46_translateNum.translateNum(220));
    }
}
