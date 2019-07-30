/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfiw.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import rfiw.data.*;

/**
 *
 * @author Zyh
 */
public class IOProcess {

        public static void resolvingCMD (String strCMD) throws Exception {
        String strOpCode ;
        String strUse  ;
        //RF
        String RFMachineID;
        int RFCount; 
        String RFTagData;
        int codeFinish;
        int RFTagsCount;
        
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
                RFTagData = jsonObject.getString("data");
                codeFinish = jsonObject.getInteger("finish");
                // 0729Md
                RFTagsCount = jsonObject.getInteger("count");
                if(RFTagsCount != 0){
                    // 0729MD
                    try{
                        fillRFTagList(RFTagData);
                    }
                    catch(Exception e){
                    System.out.println("标签数据数据写入订单列表失败");
                    System.out.println(e);
                  }                    
                }
                //
                if(codeFinish==1){
                    // 结束处理
                    rfiw.data.ControlData.tagsEndFlag = true;
                    //
                    System.out.println("tagsEndBit:" + rfiw.data.BillData.tagsEndBit);
                    System.out.println("billList[1][0]" + rfiw.data.BillData.billList[1][0]);
                }
            }else if("getSequenceNumber".equals(strOpCode)){
                RFMachineID = jsonObject.getString("SequenceNumber");
                rfiw.data.ControlData.machineId = RFMachineID;
                // System.out.println("what:" + ControlData.machineId);
            }
        }else if("ACSys".equals(strUse)){
            if("Q".equals(strOpCode)){
                CardID = jsonObject.getString("CardID");
                if(!rfiw.data.ControlData.inBillFlow){  
                    fillCardID(CardID);                   
                  
                  // new rfiw.network.TcpClient().tcpClient(rfiw.data.ControlData.ACSysIP01, 6003, "Q");                  
                  
                  // 请求RF开始读回收箱                 
                   rfiw.RFIW.goRequest("Read");
                   // System.out.println("do ask 1");
                }else {
                    System.out.println("inBillFlow? = " + rfiw.data.ControlData.inBillFlow);
                    new rfiw.network.TcpClient().tcpClient(rfiw.data.ControlData.ACSysIP01, ControlData.ACSysLsnPort, "Q");
                }
                new rfiw.network.TcpClient().tcpClient(rfiw.data.ControlData.ACSysIP01, ControlData.ACSysLsnPort, "Q");
              
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
        // resolvingCMD(tt);
    
    }
}
