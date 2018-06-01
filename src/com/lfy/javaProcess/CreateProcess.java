package com.lfy.javaProcess;

/**
 * java创建进程
 * @author lfy
 * @since 2018/06/01
 * */
public class CreateProcess {

	public static void main(String[] args) throws Exception {

		//1、Create Process by Runtime's exec() mothod
		CreateProcess temp=new CreateProcess();
		temp.useRuntime();
		//2、Create Process by ProcessBuilder
		temp.useProcessBuilder();
	}
	
	private void useRuntime()throws Exception{
		Runtime run=Runtime.getRuntime();
		//open notepad or D:\\eclipse\\eclipse.exe
		run.exec("notepad");
	}
	
	private void useProcessBuilder()throws Exception{
		//open notepad or D:\\eclipse\\eclipse.exe
        ProcessBuilder pBuilder = new ProcessBuilder("notepad");
        pBuilder.start();
	}

}
