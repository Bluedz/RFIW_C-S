/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfiw.data;

/**
 *
 * @author Zyh
 */
public class ControlData {
    
    public static Boolean inBillFlow = false; //false;
    
    public static String frameTag; // frametag  界面切换用
    
    public static int amoutOfRFIDInExit = 9999; // amount of RF-label in exit Area
    
    public static void main(String arg[]){
     if (amoutOfRFIDInExit == 9999) {
         System.out.print("ok");
     }
    }
}
