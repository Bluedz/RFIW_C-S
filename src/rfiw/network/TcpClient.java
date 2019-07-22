/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfiw.network;
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
        String backStr = "{\"Use\": \"ACSys\", \"OpCode\": \"R\", \"DeviceID\": \"0002\", \"ReturnStatus\": \"1\"}";
        String strCMD = null ;
        if(opCode.equals("R")){
             strCMD = rfiw.service.TcpCMDList.CMDOpenDoorByID (15, rfiw.data.BillData.billOwnerID, rfiw.data.BillData.deviceID);
        }else if(opCode.equals("Q")) {
            if(rfiw.data.ControlData.inBillFlow){
            strCMD = "{\"Use\": \"ACSys\",\"OpCode\": \"Q\",\"DeviceID\": \"0001\",\"ReturnStatus\": \"0\",\"Password\": \"00000000\"}";
            }else {
            strCMD = "{\"Use\": \"ACSys\",\"OpCode\": \"Q\",\"DeviceID\": \"0001\",\"ReturnStatus\": \"1\",\"Password\": \"00000000\"}";
            rfiw.data.ControlData.inBillFlow = true;
            }
        }
        
        // "{\"Use\": \"ACSys\",\"OpCode\": \"R\",\"DeviceID\": \"0002\",\"CardID\": \"0002926614\",\"TimeOut\": 15,\"Password\": \"00000000\"}";
        // CMDOpenDoorByID (int timeOut, String cardID, String deviceID);
        
        // 客户端的输出流
        OutputStream os = socket.getOutputStream();        
        // 将信息写入流,把这个信息传递给服务器
        os.write(strCMD.getBytes());
        
        // 从服务器端接收信息
        InputStream is = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int length = is.read(buffer);
        String str = new String(buffer, 0, length);
        System.out.println(str);

        // backStr = getBackStr(socket);
        if ( backStr.equals(str)){
            System.out.println("Retrun from ACSys is right");

        }else{
            System.out.println("Retrun from ACSys is wrong");
            os.write(strCMD.getBytes());
        }
        
        // 关闭资源
        is.close();
        os.close();
        socket.close();
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
