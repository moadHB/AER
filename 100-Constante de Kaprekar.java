package com.example.kaprekar;
import java.util.Arrays;
import java.util.Scanner;

public class Kaprekar {
    public static void main(String[] args) {
        Kaprekar kr= new Kaprekar();
        Scanner sc = new Scanner(System.in);
        int nRepdigits= sc.nextInt();
        String repdigits;
        int[] output = new int[nRepdigits];
        for(int i=0;i<nRepdigits; i++){
            repdigits= sc.next();
            String copyRepdigits = repdigits;
            if (kr.nValido(copyRepdigits)){
                int count = 0;
                while (!copyRepdigits.equals("6174")){
                    if (copyRepdigits.length()<4){
                        for (int k = 0; k < 4-copyRepdigits.length(); k++) {
                            copyRepdigits = "0" + copyRepdigits;
                        }
                    }
                    copyRepdigits = String.valueOf(kr.next(copyRepdigits.split("")));
                    count++;
                }
                output[i]=count;
            }else {
                output[i]=8;
            }
        }
        for (int a : output) {
            System.out.println(a);
        }
    }
    public boolean nValido(String n){
        boolean vf= true;
        if( n.length()>4){ vf= false; }
        if( (n.charAt(0) == n.charAt(1)) &&
            (n.charAt(0) == n.charAt(2)) &&
            (n.charAt(0) == n.charAt(3)) ) { vf = false; }

        return vf;
    }
    public int next(String[] ns){
        int asc=0;
        int des=0;
        int n=0;
        int[] ni= new int[4];
        for (int i = 0; i < 4; i++) {
            ni[i]=Integer.parseInt(ns[i]);
        }
        Arrays.sort(ni);
        for (int a : ni) {
            asc = 10*asc + a;
        }
        for (int i = 3; i>=0 ; i--) {
            des = 10*des + ni[i];
        }
        n=des-asc;
        return n;
    }

}
//--------------------------------------------------------------------------------------
