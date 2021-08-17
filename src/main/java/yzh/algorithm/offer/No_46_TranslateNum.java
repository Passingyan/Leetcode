package yzh.algorithm.offer;

/**
 * @author yongzh
 * @date 2021/8/17
 */
public class No_46_TranslateNum {
    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        int a1 = 1;
        int index = 1;
        boolean flag = true;
        int temp;
        while (index < numStr.length()) {
            temp = Integer.parseInt(numStr.substring(index - 1, index + 1));
            if (temp >= 10 && temp <= 25) {
                if (flag) {
                    a1++;
                } else {
                    a1 += 2;

                }
            } else {
                flag = false;
            }
            index++;
        }
        return a1;
    }

    public static void main(String[] args) {
        No_46_TranslateNum no_46_translateNum = new No_46_TranslateNum();
        System.out.println(no_46_translateNum.translateNum(220));
    }
}
