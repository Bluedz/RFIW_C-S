package rfiw.network;

import java.net.ServerSocket;
import java.net.Socket;

public class MainServer
{
    // public static void main(String[] args) throws Exception
    public MainServer() throws Exception
    {
        //int port1 = 6000; // Door
        // int port2 = 5000; // RFID
        
        int port2 = 6000;
       // ServerSocket serverSocket1 = new ServerSocket(port1);
        ServerSocket serverSocket2 = new ServerSocket(port2);

        while (true)
        {
            // 一直处于监听状态,这样可以处理多个用户
         //   Socket socket1 = serverSocket1.accept();
            Socket socket2 = serverSocket2.accept();

            // 启动读写线程
          //  new ServerInputThread(socket1).start();
            new ServerInputThread2(socket2).start();
            //// new ServerOutputThread(socket).start();

        }

    }

}