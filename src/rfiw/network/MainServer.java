package rfiw.network;

import java.net.ServerSocket;
import java.net.Socket;

public class MainServer
{
    // public static void main(String[] args) throws Exception
    public MainServer(int port) throws Exception
    {
        ServerSocket serverSocket = new ServerSocket(port);

        while (true)
        {
            // 一直处于监听状态,这样可以处理多个用户
            Socket socket = serverSocket.accept();

            // 启动读写线程
            new ServerInputThread(socket).start();
            //// new ServerOutputThread(socket).start();

        }

    }

}