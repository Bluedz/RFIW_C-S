/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfiw.TestPak;

import java.util.Random;

/**
 *
 * @author Zyh
 */
public class RandomFun {
    public static int getRandom(){
        int num = (int)Math.floor(Math.random()*10);
        return num;
    }
    
    public static String getRandom2(){
        String Num=""; 
        String base = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLNMOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<6; i++){
            int number = random.nextInt(base.length());
            char n = base.charAt(number);
            if(Num.indexOf(n)!= -1){
                if(i!=0) i--;
            }else {
                Num += n + " ";
            }
        }
        
        return Num; 
        
        
    }
    
    public static char getRandomStr(){
        String base = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLNMOPQRSTUVWXYZ";
        Random random = new Random();
        int number = random.nextInt(base.length());
        char n = base.charAt(number);
        
        return n;
        
    }
    
    public static void main(String[] args){
//        System.out.println(getRandom());
//        String Num="";
//        for(int i=0;i<6;i++){
//            int n = getRandom();
//            if(Num.indexOf(Integer.toString(n)) != -1){
//                if(i != 0) i--;
//            }else{
//                Num += n + " ";
//            }
//        }
//        
//        System.out.println(Num);
//        System.out.println(getRandom2());
        String[] str = new String[30000]; //3844
        int count=0;
        
        for(int i=0;i<30000;i++){ //3844
            str[i] = getRandomStr()+""+
                    getRandomStr()+""+
                    getRandomStr()+""+
                    getRandomStr()+""+
                    //getRandomStr()+""+
                    getRandomStr();
            //System.out.println((i+1) + " : "+ str[i]);  
            for(int j=0; j<i; j++){
                if ((str[i]).equals(str[j])){
                     System.out.println(" > " + j);
                     count++;
                }
            }
        }
        System.out.println("count:" + count);
        
        
        
    }
}
