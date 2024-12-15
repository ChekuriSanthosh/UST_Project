package com.ust.practise;

import java.util.Random;

public class Strings {
    public static void main(String[] args) {
//        Random rand=new Random();
//        String password="abcdefghijklmnopqrstuvwxyz!@#$%^&*()";
//        String ans="";
//        for(int i=0;i<8;i++){
//            ans=ans+password.charAt((rand.nextInt(36)));
//        }
//
//        System.out.println(ans);
        int a=20;
        String res=String.valueOf(a);
        System.out.println(res);
        String str="UST GLOBAL";
        String str1=str.replace('U','S');
        var chars=str1.toCharArray();
        for(char c:chars){
            System.out.print(c +"\t");
        }


    }
}
