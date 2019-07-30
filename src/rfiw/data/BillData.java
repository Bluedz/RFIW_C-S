/*-
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfiw.data;

/**
 *
 * @author Zyh
 */
public class BillData {
    //0729Md public static String deviceID = "0002";
    public static String billOwnerID = "0011609586"; //0000666666 not default
    public static int tagsEndBit = 0;
    public static String[][] billList = new String[100][4];
    /*
            new String [][] {
            {"code", "mat", "batch", "stock"},
            {"b00", "b01", "b02","b03"},
            {"b10", "b11", "b12","b13"},
            {"b20", "b21", "b22","b23"}
        };*/
    private static String[][] billLsit0 =
            new String [][] {
            {"code", "mat", "batch", "stock"}
        };

    public static void appendLine(String[] str){
       
        int length, length2;
        length = billList[tagsEndBit].length;
        length2 = str.length;
        System.arraycopy(str, 0, billList[tagsEndBit], 0, length);
        tagsEndBit++;
        
    } 
    
    public static void main(String args[]){
        String str[] = new String [] {"b10", "b01", "b02","b03"}; 
        String str2[] = new String [] {"b20", "b01", "b02","b03"}; 
        String str3[] = new String [] {"b30", "b01", "b02","b03"}; 
        appendLine(str);
        appendLine(str2);
        appendLine(str3);
        System.out.print(billList[0][0]);System.out.print(billList[1][0]);
        System.out.print(billList[2][0]);System.out.print(billList[3][0]);
        
    }
    
}
