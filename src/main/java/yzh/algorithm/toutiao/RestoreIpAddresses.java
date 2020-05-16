package yzh.algorithm.toutiao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yongzh
 * @date 2020/5/16
 */
public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        int length = s.length();
        String first, second, third, fourth;
        if (length < 4 || length > 12) return list;
        int index, index2, index3;
        index = 1;
        while (index <= 3) {
            if (length - index < 3 || length - index > 9) {
                break;
            }
            first = s.substring(0, index);
            if (isIp(first)) {
                index2 = 1;
                while (index2 <= 3) {
                    if (length - index - index2 < 2 || length - index - index2 > 6) {
                        break;
                    }
                    second = s.substring(index, index + index2);
                    if (isIp(second)) {
                        index3 = 1;
                        while (index3 <= 3) {
                            if (length - index - index2 - index3 < 1 || length - index - index2 - index3 > 3) {
                                break;
                            }
                            third = s.substring(index + index2,
                                    index + index2 + index3);
                            fourth = s.substring(index + index2 + index3);
                            if (isIp(third) && isIp(fourth)) {
                                list.add(first + "." + second + "." + third + "." + fourth);
                            }
                            index3++;
                        }
                    }
                    index2++;
                }
            }
            index++;
        }


        // for (int i = 1; i <= 3 && i <= length - 3 && length - i <= 9; i++) {
        //     first = s.substring(0, i);
        //     if (isIp(first)) {
        //         for (int j = 1; j <= 3 && j <= length - i - 2 && length - i - j <= 6; j++) {
        //             second = s.substring(i, i + j);
        //             if (isIp(second)) {
        //                 for (int k = 1; k <= 3 && k <= length - i - j - 1 && length - i - j - k <= 3; k++) {
        //                     third = s.substring(i + j, i + j + k);
        //                     fourth = s.substring(i + j + k);
        //                     if (isIp(third) && isIp(fourth))
        //                         list.add(first + "." + second + "." + third + "." + fourth);
        //                 }
        //             }
        //         }
        //     }
        // }
        return list;
    }

    private boolean isIp(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') return false;
        int ipNum = Integer.parseInt(s);
        return ipNum >= 0 && ipNum <= 255;
    }


    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        System.out.println(restoreIpAddresses.restoreIpAddresses("25525511135"));
    }
}
