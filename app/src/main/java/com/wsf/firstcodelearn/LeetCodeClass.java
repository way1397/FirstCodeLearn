package com.wsf.firstcodelearn;

import android.net.Uri;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

class LeetCodeClass {

    public static void main(String[] args) {
//        System.out.print(romanToInt("lll"));//1994

        String url="http://192.168.101.201:9999/dfwl/阿里巴巴Android面试题集（答案解析）.pdf";
        try {
            String result= Uri.encode(url, "-![.:/,%?&=]");
            Log.e("test", "main: "+result );
        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        List<String>a =new ArrayList<>();
        a.clear();

    }





    /**
     * pre=m1000
     * i=1 num=c100   pre>num sum=sum+pre=o+1000=1000 pre=100
     * i=2 num=m1000 pre<num sum=sum-pre=1000-100=900 pre=1000
     * i=3 num=x10 pre>num sum=sum+pre=1900 pre=10
     * i=4 num=c100 pre<num sum=sum-pre=1890 pre=100
     * i=5 num=i1 pre>num sum=sum+pre=1990 pre1
     * i=6 num=v5 pre<num sum=sum-pre=1989 pre5
     * 循环结束
     * 循环外要把pre加上去
     * 最后得出，sun=sum+pre=1994
     */
//    public static int romanToInt(String s) {
//        int sum = 0;
//        int preNum = getValue(s.charAt(0));
//        for (int i = 1; i < s.length(); i++) {
//            int num = getValue(s.charAt(i));
//            if (preNum < num) {
//                sum -= preNum;
//            } else {
//                sum += preNum;
//            }
//            preNum = num;
//        }
//        sum += preNum;
//        return sum;
//    }
//    public String longestCommonPrefix(String[] strs) {

//    }
}
