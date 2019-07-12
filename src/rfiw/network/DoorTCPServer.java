/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfiw.network;

import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author Zyh
 */
public class DoorTCPServer {
    
        public DoorTCPServer(int port) throws Exception
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
