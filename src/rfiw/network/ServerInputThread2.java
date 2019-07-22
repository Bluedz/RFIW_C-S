/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfiw.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zyh
 */
public class ServerInputThread2 extends Thread{
        private Socket socket;

    public ServerInputThread2(Socket socket)
    {
        super();
        this.socket = socket;
    }

    @Override
    public void run()
    {
        try
        {
            // 获得输入流
            InputStream is = socket.getInputStream();


            // 服务器端的输出流，向客户端发送信息
            OutputStream os = socket.getOutputStream();
            
             String repOk2RF = "{\"Receive\": \"ok\"}";
            // String repOk2RF = "{\"Use\": \"ACSys\",\"OpCode\": \"R\",\"DeviceID\": \"0001\",\"CardID\": \"0002926614\",\"TimeOut\": \"15\",\"Password\": \"00000000\"}";
            

            while (true)
            {
                byte[] buffer = new byte[1024];
                int length = is.read(buffer);
                String str = new String(buffer, 0, length);
                System.out.println(str);
                try {
                    // rfiw.service.IOProcess.resolvingCMD("{\"Use\": \"RFID\", \"OpCode\": \"ReadCount\", \"Section\": 1, \"count\": 1}");
                    rfiw.service.IOProcess.resolvingCMD(str);
                } catch (Exception ex) {
                    Logger.getLogger(ServerInputThread2.class.getName()).log(Level.SEVERE, null, ex);
                }
                // rfiw.service.IOProcess.tcpInStr(str, 5000);
                os.write(repOk2RF.getBytes());

            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
