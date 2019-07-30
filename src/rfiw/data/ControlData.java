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
    
    public static String ACSysIP01 = "192.168.90.203"; 
    // public static String ACSysIP01 = "127.0.0.1";
    public static String ACSysIP02 = "192.168.90.204";  
    public static int ACSysLsnPort = 6000; //6003;
    public static int ACSysCntPort = 6000;
    public static String ACSysPSW = "00000000";
    
    public static String machineId = "E192124";
    public static String RFRead01 = "127.0.0.1";   
    // public static String RFRead01 = "192.168.11.56";
    public static int RFLsnPort = 6010;
    public static int RFCntPort = 6000;
    
    public static String ACSysDevice01 = "0001"; 
    public static String ACSysDevice02 = "0002";
    
    public static Boolean inBillFlow = false; //false;    
    public static String frameTag; // frametag  界面切换用    
    public static int amoutOfRFIDInExit = 9999; // amount of RF-label in exit Area    
    public static boolean tagsEndFlag = false;
    
    public static void main(String arg[]){
     if (amoutOfRFIDInExit == 9999) {
         System.out.print("ok");
     }
    }
}
