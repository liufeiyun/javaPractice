package com.lfy.javaSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketService {
    
    public static void main(String[] args) throws IOException{
        SocketService socketService = new SocketService();
        socketService.oneServer();
    }
    public  void oneServer(){
        try{
            ServerSocket server=null;
            try{
                server=new ServerSocket(5209);
                //1��ָ���󶨵Ķ˿ڣ��������˶˿ڡ�
                System.out.println("�����������ɹ�");
            }catch(Exception e) {
                    System.out.println("û������������"+e);
            }
            Socket socket=null;
            try{
                socket=server.accept();
                //2������accept()������ʼ�������ȴ��ͻ��˵����� 
                //ʹ��accept()�����ȴ��ͻ������пͻ�
                //�����������һ��Socket���󣬲�����ִ��
            }catch(Exception e) {
                System.out.println("Error."+e);
                //������ӡ������Ϣ
            }
            //3����ȡ������������ȡ�ͻ�����Ϣ 
            String sendLine;
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //��Socket����õ�����������������Ӧ��BufferedReader����
            PrintWriter out=new PrintWriter(socket.getOutputStream());
            //��Socket����õ��������������PrintWriter����
            BufferedReader consoleIn=new BufferedReader(new InputStreamReader(System.in));
            //��ϵͳ��׼�����豸����BufferedReader����
            System.out.println("Client:"+in.readLine());/**socket������ʹ�ȴ��ͻ��˵����ݵ���*/
            //�ڱ�׼����ϴ�ӡ�ӿͻ��˶�����ַ���
            sendLine=consoleIn.readLine();
            //�ӱ�׼�������һ�ַ���
            //4����ȡ���������Ӧ�ͻ��˵����� 
            while(!"end".equals(sendLine)){
            	out.println(sendLine);
            	out.flush();
                //ˢ���������ʹClient�����յ����ַ���
                System.out.println("Client:"+in.readLine());/**socket������ʹ�ȴ��ͻ��˵����ݵ���*/
                //��Client����һ�ַ���������ӡ����׼�����
                sendLine=consoleIn.readLine();
                //��ϵͳ��׼�������һ�ַ���
            }
            //5���ر���Դ 
            out.close(); //�ر�Socket�����
            in.close(); //�ر�Socket������
            socket.close(); //�ر�Socket
            server.close(); //�ر�ServerSocket
        }catch(Exception e) {
            System.out.println("Error."+e);
        }
    }
}
