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
        if (port == 5000){
            String[] tt = parseJSONWithJSONObject(str);
            
            rfiw.data.BillData.billList[1] = tt;
            System.out.println(str);
            System.out.println(tt[0] + ", " + tt[1] + ", " + tt[2] + ", " + tt[3]);
            System.out.println(rfiw.data.BillData.billList[1][0]);
        }
        
    
    }
    
    private static String[] parseJSONWithJSONObject(String JsonData) {      
        String[] billListItem = {"code", "mat", "batch", "stock"} ;
        try
        {
    //        JSONArray jsonArray = new JSONArray(jsonData);
    //        for (int i=0; i < jsonArray.length(); i++)    {
    //            JSONObject jsonObject = jsonArray.getJSONObject(i);
    //            String id = jsonObject.getString("id");
    //            String name = jsonObject.getString("name");
    //            String version = jsonObect.getString("version");
    //
    //            System.out.println("id" + id + ";name" + name + ";version" + version);
    //        }
            billListItem  = 
            new String []{"c00", "c01", "c02","c03"};       

            
        }     
        catch (Exception e)
        {
            e.printStackTrace();
        }    
        
        return billListItem;
    }
}
