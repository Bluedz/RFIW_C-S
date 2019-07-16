/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfiw.service;

/**
 *
 * @author Zyh
 */
public class IOProcess {
    // process data from TcpServer
    public static void tcpInStr(String str, int port){
    /*    if (port == 5000){
            String[] tt = parseJSONWithJSONObject(str);            
            rfiw.data.BillData.billList[1] = tt;
            System.out.println(str);
            System.out.println(tt[0] + ", " + tt[1] + ", " + tt[2] + ", " + tt[3]);
            System.out.println(rfiw.data.BillData.billList[1][0]);
        }
    */
    
    // parseJson2Str(str)
    
    // find What is it & what 2 do
    
    }
    
    public static void tcpOutStr(Command, key){
    //find what is it & which is the real command line
    
    // parseStr2Json()
    
    // send Use tcpClient (server, port)
    }
    
    private static String[] parseJSONWithJSONObject(String JsonData) {      
        String[] billListItem = {"code", "mat", "batch", "stock"} ;
        try
        {   billListItem  = 
            new String []{"c00", "c01", "c02","c03"};  
        }     
        catch (Exception e)
        {
            e.printStackTrace();
        }            
        return billListItem;
    }
}
