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
public class TcpCMDList {
//Door
    // in: card ID to sys
     // cmd: { "Use": "ACSys"，"OpCode": "Q", "DeviceID": "0001", "CardID": "0000666666", "Password": "00000000" }
     // return: { "Receive": "ok"} {"Use": "ACSys", "OpCode": "Q", "ReturnStatus": "1", "Password": "00000000"}     
    public static String doorBackOk = "{\"Use\": \"ACSys\", \"OpCode\": \"Q\", \"ReturnStatus\": \"1\", \"Password\": \"00000000\"}";
        
    // out: Card with this ID can open the Door
     // cmd: {"Use": "ACSys","OpCode": "R","DeviceID": "0002","CardID": "0002926614","TimeOut": 15,"Password": "00000000"}
     // return: {"Use": "ACSys", "OpCode": "R", "DeviceID": "0002", "ReturnStatus": "1"} 
    // {"Use": "ACSys","OpCode": "R","DeviceID": "0002","ReturnStatus": "1","Password": "00000000"}
    public static String CMDOpenDoorByID (int timeOut, String cardID, String deviceID){
        return 
                "{\"Use\": \"ACSys\",\"OpCode\": \"R\",\"DeviceID\": \""+ deviceID + "\",\"CardID\": \""
                + cardID + "\",\"TimeOut\": " + timeOut + ",\"Password\": \"00000000\"}";
    }
    
//RFID
    // out: 中控要求开始读取区域2（回收箱）
     // cmd: {"Use": "RFID", "OpCode": "Read", "Section": 2, "delay": 0}
     // return: {"Use": "RFID", "OpCode": "Read", "Section": "2", "ReturnStatus": "1"}
    
    // out: 中控要求返回区域1读取结果
     // cmd: {"Use": "RFID", "OpCode": "ReadCount", "Section": 1, "delay": 2}
     // return: {"Use": "RFID", "OpCode": "ReadCount", "Section": "1", " ReturnStatus ": "1"}
    public static String CMDRFread(String opCode, int sectionNum){
        return  "{\"Use\": \"RFID\", \"OpCode\": \""+ opCode + "\", \"Section\": "+ sectionNum + ", \"delay\": 0}";
    }
    
    // in:  
    
    
    
    
    public static void main(String arg[]){
        System.out.print(CMDRFread("code01", 2));
        System.out.print(CMDOpenDoorByID(15, "90001", "002"));
    }
    
}
