package com.tian;

import java.util.Arrays;

/**
 * @author tomtian
 * @create 2021-03-19 20:20
 */
public class KMPDemo {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(perfix("ABCDABD")));
        System.out.println(Arrays.toString(backfix("ABCDABD")));
    }
    public static int[] kmpNext(String dest){
        return null;
    }

    public static String[] perfix (String str){
        char[] chars = str.toCharArray();
        String[] result = new String[str.length()-1];
        int length = str.length();
        result[0] = chars[0] + "";
        for (int i = 1; i <length-1 ; i++) {
            result[i]= result[i-1] +chars[i];
        }
        return result;
    }

    public static String[] backfix(String str){
        char[] chars = str.toCharArray();
        String[] result = new String[str.length()-1];
        int length = str.length();
        result[length-2] = chars[str.length()-1] + "";
        for (int i = length-3; i>0 ; i--) {
            result[i] = result[i-1] +chars[i];
        }
        return result;
    }
}
