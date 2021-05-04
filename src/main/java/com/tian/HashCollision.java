package com.tian;

import java.util.Arrays;

/**
 * @author tomtian
 * @create 2021-05-03 12:55
 * @Description 必须是线性探测（线性探测在散列）解决冲突，而且是key%modNum
 */
public class HashCollision {
    public int length;
    public int modNum;
    public int[] arr;
    public int[] res;
    public  int[] suss;
    public int[] fail;
    public HashCollision(int length, int modNum, int[] arr) {
        this.length = length;
        this.modNum = modNum;
        this.arr = arr;
    }
//    public int[] getAvgfindLength(){
//
//    }
    public void create(){
        res = new int[length];
        suss = new int[length];
        fail = new int[length];
    }
    public void add(int curNum){
        int count =1;
        int res = curNum%modNum;
        if (arr[res]==0){
            arr[res] = curNum;
            suss[res] = count;
        }else {
            res++;
            count++;
            while (arr[res]!=0){
                res++;
                count++;
            }
            arr[res] = curNum;
            suss[res] = count;
        }
    }

    public static void main(String[] args) {

    }

}
