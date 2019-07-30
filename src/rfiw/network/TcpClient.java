/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfiw.network;
import rfiw.data.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/**
 *
 * @author WWW
 */
public class TcpClient {
    public void tcpClient(String host, int port, String opCode)throws Exception{
        Socket socket = new Socket(host, port);
        //* String backStr = "{\"Use\": \"ACSys\", \"OpCode\": \"R\", \"DeviceID\": \"0002\", \"ReturnStatus\": \"1\"}";
        String backStr = null;
        String strCMD = null ;
        if(opCode.equals("R")){
            //0729Md 
            strCMD = rfiw.service.TcpCMDList.CMDOpenDoorByID (15, rfiw.data.BillData.billOwnerID, rfiw.data.ControlData.ACSysDevice02, ControlData.ACSysPSW);
             backStr = "{\"Use\": \"ACSys\", \"OpCode\": \"R\", \"DeviceID\": \"0002\", \"ReturnStatus\": \"1\"}";
        }else if(opCode.equals("Q")) {
            if(rfiw.data.ControlData.inBillFlow){
            strCMD = rfiw.service.TcpCMDList.CMDAccessInOK(rfiw.data.ControlData.ACSysDevice01, "0", ControlData.ACSysPSW);
            //0729Md "{\"Use\": \"ACSys\",\"OpCode\": \"Q\",\"DeviceID\": \"0001\",\"ReturnStatus\": \"0\",\"Password\": \"00000000\"}";
            backStr = "hi";
            }else {
            strCMD = rfiw.service.TcpCMDList.CMDAccessInOK(rfiw.data.ControlData.ACSysDevice01, "1", ControlData.ACSysPSW) ;
            //0729Md "{\"Use\": \"ACSys\",\"OpCode\": \"Q\",\"DeviceID\": \"0001\",\"ReturnStatus\": \"1\",\"Password\": \"00000000\"}";
            backStr = "hi";
            rfiw.data.ControlData.inBillFlow = true;
            }
        }else if(opCode.equals("Read")){
            strCMD = rfiw.service.TcpCMDList.CMDRFRead(opCode, 2, 0);
            backStr = rfiw.service.TcpCMDList.reCMDRFRead(opCode, 2);
        }else if(opCode.equals("ReadCount")){
            strCMD = rfiw.service.TcpCMDList.CMDRFRead(opCode, 1, 2);
            backStr = rfiw.service.TcpCMDList.reCMDRFRead(opCode, 1);
        }else if(opCode.equals("backData")){
            strCMD = rfiw.service.TcpCMDList.CMDRFRead(opCode, 2, 0);
            backStr = rfiw.service.TcpCMDList.reCMDRFRead(opCode, 2);;
        }else if(opCode.equals("getSequenceNumber")){
            strCMD = rfiw.service.TcpCMDList.CMDRFGetMachineID(opCode);
            backStr = rfiw.service.TcpCMDList.reCMDRFGetMachineID(opCode);
        }   
        
        // "{\"Use\": \"ACSys\",\"OpCode\": \"R\",\"DeviceID\": \"0002\",\"CardID\": \"0002926614\",\"TimeOut\": 15,\"Password\": \"00000000\"}";
        // CMDOpenDoorByID (int timeOut, String cardID, String deviceID);
        
        // 客户端的输出流
        OutputStream os = socket.getOutputStream();        
        // 将信息写入流,把这个信息传递给服务器
        os.write(strCMD.getBytes());
        //0729Md
        System.out.println("SendOut:" + strCMD);
        
        // 从服务器端接收信息
        InputStream is = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int length = is.read(buffer);
        String str = new String(buffer, 0, length);
        System.out.println("ReturnV:" + str);

        // backStr = getBackStr(socket);
        if ( backStr.equals(str)){
            System.out.println("Retrun from Device is right");

        }else{
            System.out.println("Retrun from Device is wrong");
            System.out.println("- Wbakstr:" + backStr);
            System.out.println("- Rbakstr:" + str);
            os.write(strCMD.getBytes());
        }
        
        // 关闭资源
        is.close();
        os.close();
        socket.close();
        
        //System.out.println("do ask");
        // rfiw.RFIW.goRequest("Read");
    }
    
    private String getBackStr(Socket socket)throws Exception{
        InputStream is = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int length = is.read(buffer);
        String str = new String(buffer, 0, length);
        System.out.println(str);
        //is.close();
        return str;
    }
    
    public static void main(String[] args) throws Exception
    {
        // new TcpClient().tcpClient("127.0.0.1", 6000);
    }
}
