package com.StringClass.java;

/**
 * @author sunjiacheng
 * @create 2019-12-19-15:47
 */

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 常见String类面试题
 * （1）模拟trim()方法，去除字符串两端的空格
 * （2）将一个字符串进行反转，将字符串中指定部分进行反转
 * （3）去一个字符串在另一个字符串中出现的次数
 * （4）获取两个字符串中最大相同子串***
 * （5）对字符串中的字符进行自然顺序排序
 */

public class TestStringClass
{
    public static void main(String[] args)
    {
        TestStringClass tsc = new TestStringClass();

        String str = tsc.trimTest("      adfsafsadf    dsfasfa   ");
        System.out.println(str);

        String str1 = tsc.reveseTest("abcdefghigk123", 2, 5);
        System.out.println(str1);

        int time = tsc.timeStrTest("abkjljkgkdgjkdabjskldgsdjgabjssab", "ab");
        System.out.println(time);
        time = tsc.timeStrTest("123gad123faffa123gafgafag32123dafsd32d123sfaf", "123");
        System.out.println(time);

        ArrayList<String> arrayList = tsc.maxSubString("abcwerthelloyuiodef", "cvhellobnmabcwer");
        Iterator<String> iterator = arrayList.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

        String str2 = tsc.sortString("gadgka435jgkgh45ajkghAGJKD454HGKAHGKA454544");
        System.out.println(str2);
    }

    //（1）模拟trim()方法，去除字符串两端的空格
    public String trimTest(String str)
    {
        int x = 0;
        int y = 0;
        String result_temp = "";
        String result = "";

        char[] chars = str.toCharArray();
        if(chars[0] == ' ') {
            result_temp = this.trim_temp_1(str);

            chars = result_temp.toCharArray();
            if(chars[chars.length-1] == ' ')
            {
                result = this.trim_temp_2(result_temp);
            }
        }else if(chars[chars.length-1] == ' ') {
            result = this.trim_temp_2(str);
        }else{
            result = str;
        }
        return result;
    }

    public String trim_temp_1(String str)
    {
        int x = 0;
        String result = "";
        char[] chars = str.toCharArray();
        if(chars[0] == ' ') {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ' ' && x == 0) {
                    continue;
                } else {
                    x++;
                    result += chars[i];
                }
            }
        }
        return result;
    }
    public String trim_temp_2(String str)
    {
        int y = 0;
        String result_temp = "";
        String result = "";
        char[] chars = str.toCharArray();
        if(chars[chars.length-1] == ' ')
        {
            for (int j = chars.length-1; j >= 0; j--) {
                if(chars[j] == ' ' && y == 0) {
                    continue;
                }else{
                    y++;
                    result_temp += chars[j];
                }
            }
            chars = result_temp.toCharArray();
            for (int j = chars.length-1; j >= 0; j--) {
                result += chars[j];
            }
        }
        return result;
    }

    //（2）将一个字符串进行反转，将字符串中指定部分进行反转
    public String reveseTest(String str, int index, int len)
    {
        char temp = ' ';
        char[] chars = str.toCharArray();
        for (int i = index, j = (index + len - 1); i < (index + len) && j >= index; i++, j--) {
            if(i < j){
                temp = chars[j];
                chars[j] = chars[i];
                chars[i] = temp;
            }
        }
        String result = new String(chars);
        return result;
    }

    //（3）去一个字符串在另一个字符串中出现的次数
    public int timeStrTest(String str, String subStr)
    {
        int time = 0;
        char[] chars = str.toCharArray();
        char[] chars_sub = subStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == chars_sub[0])
            {
                int j = 0;
                int x = i;
                for(j = 0; j < chars_sub.length; j++, x++)
                {
                    if(chars[x] == chars_sub[j]) {
                        continue;
                    }else{
                        break;
                    }
                }
                if(j == chars_sub.length) {
                    time++;
                }
            }
        }
        return time;
    }

    //（4）获取两个字符串中最大相同子串
    public ArrayList<String> maxSubString(String str1, String str2)
    {
        ArrayList<String> arrayList = new ArrayList<>();
        if(str1 != null && str2 != null){
            String maxString = (str1.length() > str2.length()) ? str1 : str2;
            String minString = (str1.length() > str2.length()) ? str2 : str1;

            int length = minString.length();
            for (int i = 0; i < length; i++) {
                for(int x = 0, y = length-i; y <= length; x++, y++){
                    String subStr = minString.substring(x, y);
                    if(maxString.contains(subStr)){
                        arrayList.add(subStr);
                    }
                }
                if(arrayList.size() != 0)
                    break;
            }
        }
        return arrayList;
    }

    //（5）对字符串中的字符进行自然顺序排序
    public String sortString(String str)
    {
        char temp = ' ';
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for(int j = i; j < chars.length; j++){
                if(chars[i] > chars[j]){
                    temp = chars[j];
                    chars[j] = chars[i];
                    chars[i] = temp;
                }
            }
        }
        String result = new String(chars);
        return result;
    }
}


