/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfiw.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author Zyh
 */
public class IOProcess {
/*
    // process data from TcpServer
    public static void tcpInStr(String str, int port){
        if (port == 5000){
            String[] tt = parseJSONWithJSONObject(str);            
            rfiw.data.BillData.billList[1] = tt;
            System.out.println(str);
            System.out.println(tt[0] + ", " + tt[1] + ", " + tt[2] + ", " + tt[3]);
            System.out.println(rfiw.data.BillData.billList[1][0]);
        }
    
    
    // parseJson2Str(str)
    
    // find What is it & what 2 do
    
    }
    
//    public static void tcpOutStr(Command, key){
//    //find what is it & which is the real command line
//    
//    // parseStr2Json()
//    
//    // send Use tcpClient (server, port)
//    }
    
//    private static String[] parseJSONWithJSONObject(String JsonData){      
//        String[] billListItem = {"code", "mat", "batch", "stock"} ;
//        try
//        {   billListItem  = 
//            new String []{"c00", "c01", "c02","c03"};  
//        }     
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }            
//        return billListItem;
//    }
*/
        public static void resolvingCMD (String strCMD) {
        String strOpCode ;
        String strUse  ;
        //RF
        int RFCount; 
        String RFTagData;
        int codeFinish;
        //ACsys
        String CardID;
                
        JSONObject jsonObject  = decodeCMD(strCMD);
        strOpCode = jsonObject.getString("OpCode");
        strUse = jsonObject.getString("Use");
        
        if("RFID".equals(strUse)){
            if("ReadCount".equals(strOpCode)){
                RFCount = jsonObject.getInteger("count");
                 fillRFCount(RFCount);
            }else if("Read".equals(strOpCode)){
                RFTagData = jsonObject.getString("Data");
                codeFinish = jsonObject.getInteger("finish");
                fillRFTagList(RFTagData);
                if(codeFinish==1){
                    System.out.println(rfiw.data.BillData.tagsEndflag);
                    System.out.println(rfiw.data.BillData.billList[1][0]);
                }
            }
        }else if("ACSys".equals(strUse)){
            if("Q".equals(strOpCode)){
                CardID = jsonObject.getString("CardID");
                 fillCardID(CardID);
            }
        }else System.out.println("unkown command");
    }
    
    
    public static void fillRFCount(int count){
        //
        rfiw.data.ControlData.amoutOfRFIDInExit = count;
        System.out.println("RFCount = " + rfiw.data.ControlData.amoutOfRFIDInExit);
    }
        
    public static void fillRFTagList(String hexStr){
        //
        String str = rfiw.service.StrHexExchange.hex2Str(hexStr);
        String[] strArr = str.split(",");
        System.out.println(str +"="+strArr[0]);
        rfiw.data.BillData.appendLine(strArr);
        // rfiw.Pg_Bill.main(strArr);
        
    }
    
    public static void fillCardID(String str){
        //
        rfiw.data.BillData.billOwnerID = str;
        System.out.println("billOwnerID = " + rfiw.data.BillData.billOwnerID);
    }    
        
    public static JSONObject decodeCMD (String strCMD){
        String jsonStr = strCMD;
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        return jsonObject;        
    }
    
    public static void test(){
        System.out.println("=");
    }
    public static void main(String arg[]){
    // System.out.print(CMDRFRead("code01", 2));
    // System.out.print(CMDOpenDoorByID(15, "90001", "002"));
    //    resolvingCMD("{\"Use\": \"RFID\", \"OpCode\": \"ReadCount\", \"Section\": 1, \"count\": 1}");
    //    resolvingCMD("{\"Use\": \"RFID\", \"OpCode\":\"Read\", \"Section\": 2, \"Data\": \"ABCDEF1234567890\", \"count\": 1, \"finish\": 0}");
    //    resolvingCMD("{ \"Use\": \"ACSys\", \"OpCode\": \"Q\", \"DeviceID\": \"0001\", \"CardID\": \"0000666666\", \"Password\": \"00000000\" }");
        String t1  = "{\"Use\": \"RFID\", \"OpCode\":\"Read\", \"Section\": 2, \"count\": 1, \"finish\": 0";
        String t2  = ", \"Data\": \"" +
                "53463630303131372C4430303030303030303030303134352C3353313530303041303032"
                +"\"}";
        String tt = t1 + t2;
        resolvingCMD(tt);
    
    }
}
