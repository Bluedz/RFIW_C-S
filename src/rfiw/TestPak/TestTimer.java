/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfiw.TestPak;
import java.util.*;  
/**
 *
 * @author Zyh
 */
public class TestTimer {
        public void setTimer (int totalTime){
            Timer timer = new Timer();// 实例化Timer类  
        timer.schedule(new TimerTask() {  
            public void run() {  
                System.out.println("退出");  
                this.cancel();  
            }  
        }, totalTime);// 这里百毫秒  
        System.out.println("本程序存在5秒后自动退出");  
        }
    
        public static void main(String[] args) {  
            new TestTimer().setTimer(3000);
//        Timer timer = new Timer();// 实例化Timer类  
//        timer.schedule(new TimerTask() {  
//            public void run() {  
//                System.out.println("退出");  
//                this.cancel();  
//            }  
//        }, 2000);// 这里百毫秒  
//        System.out.println("本程序存在5秒后自动退出");  

    }  
}
    
