package com.lfy.javaSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
    
    public static void main(String[] args) throws IOException {
        try {
            // 1、创建客户端Socket，指定服务器地址和端口
             Socket socket=new Socket("127.0.0.1",5209);
            System.out.println("客户端启动成功");
            // 2、获取输出流，向服务器端发送信息
            // 向本机的5209端口发出客户请求
            BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));
            // 由系统标准输入设备构造BufferedReader对象
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            // 由Socket对象得到输出流，并构造PrintWriter对象
            //3、获取输入流，并读取服务器端的响应信息 
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 由Socket对象得到输入流，并构造相应的BufferedReader对象
            String readline;
            readline = consoleIn.readLine();
            while (!"end".equals(readline)) {
            	out.println(readline);
            	out.flush();
                // 刷新输出流，使Server马上收到该字符串
                System.out.println("Server:" + in.readLine());/**socket会阻塞使等待服务端的数据到来*/
                // 从Server读入一字符串，并打印到标准输出上
                readline = consoleIn.readLine();
            }
            //4、关闭资源 
            out.close(); // 关闭Socket输出流
            in.close(); // 关闭Socket输入流
            socket.close(); // 关闭Socket
        } catch (Exception e) {
            System.out.println("can not listen to:" + e);
        }
    }
}
