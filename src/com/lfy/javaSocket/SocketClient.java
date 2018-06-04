package com.lfy.javaSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
    
    public static void main(String[] args) throws IOException {
        try {
            // 1�������ͻ���Socket��ָ����������ַ�Ͷ˿�
             Socket socket=new Socket("127.0.0.1",5209);
            System.out.println("�ͻ��������ɹ�");
            // 2����ȡ���������������˷�����Ϣ
            // �򱾻���5209�˿ڷ����ͻ�����
            BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));
            // ��ϵͳ��׼�����豸����BufferedReader����
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            // ��Socket����õ��������������PrintWriter����
            //3����ȡ������������ȡ�������˵���Ӧ��Ϣ 
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // ��Socket����õ�����������������Ӧ��BufferedReader����
            String readline;
            readline = consoleIn.readLine();
            while (!"end".equals(readline)) {
            	out.println(readline);
            	out.flush();
                // ˢ���������ʹServer�����յ����ַ���
                System.out.println("Server:" + in.readLine());/**socket������ʹ�ȴ�����˵����ݵ���*/
                // ��Server����һ�ַ���������ӡ����׼�����
                readline = consoleIn.readLine();
            }
            //4���ر���Դ 
            out.close(); // �ر�Socket�����
            in.close(); // �ر�Socket������
            socket.close(); // �ر�Socket
        } catch (Exception e) {
            System.out.println("can not listen to:" + e);
        }
    }
}
