package yzh.algorithm.toutiao;

/**
 * @author yongzh
 * @date 2020/5/16
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Multiply {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int[] arr = new int[num1.length() + num2.length()];
        int index = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            int k = index;
            for (int j = num2.length() - 1; j >= 0; j--) {
                arr[k++] += (num2.charAt(j) - '0') * n1;
            }
            index++;
        }
        int add = 0;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < arr.length; j++) {
            if (j == arr.length - 1) {
                if (arr[j] + add == 0) continue;
            }
            sb.append((arr[j] + add) % 10);
            add = (arr[j] + add) / 10;
        }
        return sb.reverse().toString();
    }
}
